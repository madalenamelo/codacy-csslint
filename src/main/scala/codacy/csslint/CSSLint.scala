package codacy.csslint

import java.nio.file.Path

import codacy.dockerApi._
import codacy.dockerApi.utils.{CommandRunner, ToolHelper}

import scala.util.Try

object CSSLint extends Tool {

  override def apply(path: Path, conf: Option[List[PatternDef]], files: Option[Set[Path]])(implicit spec: Spec): Try[List[Result]] = {
    Try {
      val fullConfig = ToolHelper.getPatternsToLint(conf)
      val filesToLint: List[String] = files.fold(List(path.toString)) {
        paths =>
          paths.map(_.toString).toList
      }

      val command = List("csslint", "--format=codacy") ++ filesToLint

      CommandRunner.exec(command) match {
        case Right(resultFromTool) =>
          parseResult(resultFromTool.stdout, fullConfig)
        case Left(failure) =>
          throw failure
      }
    }
  }

  def parseResult(lines: List[String], fullConfig: Option[List[PatternDef]]): List[Result] = {
    val RegMatch = """(.*):>line:([0-9]+),(.*),([a-zA-Z]+):(.*)""".r

    val configIds = fullConfig.toList.flatten.map(_.patternId.value)

    lines.collect {
      case RegMatch(file, line, patternId, level, message) if fullConfig.exists(_.isEmpty) || configIds.contains(patternId) =>
        Issue(
          SourcePath(file),
          ResultMessage(message),
          PatternId(patternId),
          ResultLine(line.toInt)
        )
    }
  }

}
