package Wordcount

import scala.io.Source.fromInputStream

object HHGTGData {
  def data: Iterator[String] = fromInputStream(getClass.getResourceAsStream("/hhgttg.txt")).getLines()
}