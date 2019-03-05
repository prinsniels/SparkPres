package Wordcount

import scala.io.Source.fromInputStream

object HHGTGData {
  val data: Iterator[String] = fromInputStream(getClass.getResourceAsStream("/hhgttg.txt")).getLines()
}