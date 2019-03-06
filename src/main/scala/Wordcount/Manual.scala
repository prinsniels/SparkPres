package Wordcount

object Manual {
  val wordCount: Map[String, Int] = HHGTGData.data
    // split on spaces -> list of WORDS
    .flatMap(_.split(" "))
    // make lover case
    .map(_.toLowerCase.strip)
    // remove all WORDS that are no words =D
    .filter(x => !x.isEmpty || !x.isBlank)
    // collect in a map
    .foldLeft(Map.empty[String, Int])((x, y) => x + (y -> (x.getOrElse(y, 0) + 1)))


  val wordCountMRD: Map[String, Int] = HHGTGData.data
    // split on spaces -> list of WORDS
    .flatMap(_.split(" "))
    // make lover case
    .map(_.toLowerCase.strip)
    // remove all WORDS that are no words =D
    .filter(x => !x.isEmpty || !x.isBlank)
    // Group by word
    .toSeq.groupBy(x => x)
    // count the occurrences
    .mapValues(_.size)


  def main(args: Array[String]): Unit = {

    // Sort and print the map
    wordCount.toSeq.sortBy(-_._2) take 10 foreach println
    println
    wordCountMRD.toSeq.sortBy(-_._2) take 10 foreach println

  }
}
