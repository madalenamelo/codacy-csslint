package codacy.csslint

import com.codacy.plugins.api.{Options, Source}
import com.codacy.plugins.api.results.{Pattern, Result, Tool}
import com.codacy.tools.scala.seed.utils.CommandRunner

import scala.util.{Failure, Success, Try}

object CSSLint extends Tool {

  lazy val CssLintMatch = """(.*): line ([0-9]*),.*, ([a-zA-Z]+) - (.*) \((.*)\)""".r

  def apply(
      source: Source.Directory,
      configuration: Option[List[Pattern.Definition]],
      files: Option[Set[Source.File]],
      options: Map[Options.Key, Options.Value]
  )(implicit specification: Tool.Specification): Try[List[Result]] = {

    val sourceDir = better.files.File(source.path)

    val patternsCliParams = configuration
      .collect {
        case pats if pats.nonEmpty =>
          val (include, ignore) = specification.patterns.partition(pat => pats.exists(_.patternId == pat.patternId))
          List(
            s"--errors=${include.map(_.patternId.value).mkString(",")}",
            s"--ignore=${ignore.map(_.patternId.value).mkString(",")}"
          )
      }
      .getOrElse(List.empty)

    val filesToLint = files.map(_.map(_.path)).getOrElse(Set(source.path))
    val command = List("csslint", "--format=compact") ++ patternsCliParams ++ filesToLint

    CommandRunner
      .exec(command, dir = Some(sourceDir.toJava))
      .fold(Failure.apply, res => Success(parseResult(res.stdout, configuration)))
  }

  def parseResult(lines: List[String], fullConfig: Option[List[Pattern.Definition]]): List[Result] = {
    lines.view
      .flatMap {
        case CssLintMatch(file, line, _, message, patternId)
            if fullConfig.forall(_.exists(_.patternId.value == patternId)) =>
          Try(line.toInt).map {
            case rLine =>
              Result.Issue(Source.File(file), Result.Message(message), Pattern.Id(patternId), Source.Line(rLine))
          }.toOption
        case _ => List.empty
      }
      .groupBy(res => (res.file, res.patternId, res.line))
      .flatMap { case (_, values) => values.headOption }
      .to(List)
  }
}
