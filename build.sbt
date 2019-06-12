import com.typesafe.sbt.packager.docker.{Cmd, ExecCmd}

name := """codacy-engine-csslint"""

version := "1.0-SNAPSHOT"

val languageVersion = "2.12.7"

scalaVersion := languageVersion

resolvers ++= Seq(
  "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.7.3" withSources(),
  "org.scala-lang.modules" %% "scala-xml" % "1.0.6" withSources(),
  "com.codacy" %% "codacy-engine-scala-seed" % "3.0.9" withSources()
)

enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)

version in Docker := "1.0"

val installAll =
  s"""apk update && apk add bash
     |&& apk add nodejs-current-npm
     |&& npm install -g csslint@1.0.3
   """.stripMargin.replaceAll(System.lineSeparator(), " ")

mappings.in(Universal) ++= resourceDirectory
  .in(Compile)
  .map { resourceDir: File =>
    val src = resourceDir / "docs"
    val dest = "/docs"

    (for {
      path <- better.files.File(src.toPath).listRecursively()
      if !path.isDirectory
    } yield path.toJava -> path.toString.replaceFirst(src.toString, dest)).toSeq
  }
  .value

val dockerUser = "docker"
val dockerGroup = "docker"

daemonUser in Docker := dockerUser

daemonGroup in Docker := dockerGroup

dockerBaseImage := "frolvlad/alpine-java"

dockerCommands := dockerCommands.value.flatMap {
  case cmd@(Cmd("ADD", _)) => List(
    Cmd("RUN", "adduser -u 2004 -D docker"),
    cmd,
    Cmd("RUN", installAll),
    Cmd("RUN", "mv /opt/docker/docs /docs"),
    ExecCmd("RUN", Seq("chown", "-R", s"$dockerUser:$dockerGroup", "/docs"): _*)
  )
  case other => List(other)
}
