package Wordcount

import org.apache.spark.sql.{Dataset, SparkSession}


object ViaSparkSQL {
  val spark: SparkSession = SparkSession
          .builder
          .appName("SimpleWordCount")
          .master("local[4]") // To runn locally; use 4 cores
          .getOrCreate


  def main(args: Array[String]): Unit = {
    import spark.implicits._
    val ds: Dataset[String] = spark.createDataset(HHGTGData.data.toSeq)

    ds.printSchema()
    ds show 10

    val words: Dataset[String] = ds.flatMap(sentence => sentence.split( " ")).map(word => word.toLowerCase().strip()).filter(word => !word.isBlank)

    words show 10

    words.groupBy("value").count().sort($"count".desc) show 10


    words.createOrReplaceTempView("HHGTG")
    spark.sql(
      """SELECT
        |   value, count(value)
        |FROM
        |   HHGTG
        |GROUP BY value
        |ORDER BY count(value) desc
        |""".stripMargin) show 10

  }

}
