package org.scoverage.coveralls

import java.io.File

object Utils {
  def mkFileFromPath(path: Seq[String]): File = {
    require(path.nonEmpty, "path cannot be empty")
    val p :: ps = path
    mkFileFromPath(new File(p), ps)
  }

  def mkFileFromPath(base: File, path: Seq[String]): File = path match {
    case p :: ps => mkFileFromPath(new File(base, p), ps)
    case _       => base
  }
}
