package Wordcount

object Manual {


  def main(args: Array[String]): Unit = {
    println( "Lets start")

    val wordCount = HHGTGData.data.
          flatMap(_.split(" "))
          .map(_.toLowerCase.strip)
          .filter(x => !x.isEmpty || !x.isBlank)
          .foldLeft(Map.empty[String, Int])( (x, y) =>  x + (y -> (x.getOrElse(y,0) + 1) ))
          .toSeq.sortBy(-_._2)

    println(wordCount)
  }
}
