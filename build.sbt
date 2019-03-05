name := "spark-datavibes-pres"
version := "0.1"
scalaVersion := "2.12.8"
val sparkVersion = "2.4.0"
resolvers += "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-sql-kafka-0-10" % sparkVersion,
  "org.postgresql" % "postgresql" % "42.2.5",
  "MrPowers" % "spark-fast-tests" % "0.17.1-s_2.12"
)
