name := "MyProject"
version := "1.0"
scalaVersion := "2.11.12"

//mainClass := Some("digitalmetering.dataAnalysis")

val sparkVersion = "2.3.1"


resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/"
)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.scalactic" %% "scalactic" % "3.0.5",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.apache.commons" % "commons-csv" % "1.5"
  //"org.apache.hadoop" % "hadoop-client" % "3.1.0"
  //"org.apache.spark" %% "spark-mllib" % sparkVersion,
  //"org.apache.spark" %% "spark-streaming" % sparkVersion,
  //"org.apache.spark" %% "spark-hive" % sparkVersion,
  //"mysql" % "mysql-connector-java" % "5.1.6"
)
