package Wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object ViaSparkRDD {

  lazy val conf: SparkConf = new SparkConf().setAppName("SimpleWordCount").setMaster("local[4]")
  lazy val sc: SparkContext = new SparkContext(conf)


  def main(args: Array[String]): Unit = {
    val lines: RDD[String] = sc.parallelize(HHGTGData.data.toSeq).persist()

    val words: RDD[String] = lines.flatMap(_.split(" ")).filter(!_.isBlank).map(_.toLowerCase)

    words take 7 foreach println

    val counts = words
      .map( word => (word, 1))
      .reduceByKey(_+_)
      .sortBy(_._2, false)

    counts take 10 foreach println

    sc stop

  }

}
