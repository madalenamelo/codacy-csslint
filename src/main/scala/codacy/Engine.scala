package codacy

import codacy.csslint.CSSLint
import com.codacy.tools.scala.seed.DockerEngine

object Engine extends DockerEngine(CSSLint)()
