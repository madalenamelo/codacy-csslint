package codacy

import codacy.dockerApi.DockerEngine
import codacy.csslint.CSSLint

object Engine extends DockerEngine(CSSLint)
