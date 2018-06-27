package digitalmetering

import org.apache.spark.sql.{DataFrame, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row
//import org.apache.spark.sql.SQLContext
//import org.apache.spark.SparkContext
import digitalmetering.dataReader.records

// For implicit conversions like converting RDDs to DataFrames

object dataAnalysis {


  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .appName("dataAnalysis")
    //.config("spark.some.config.option", "some-value")
      .config("spark.master", "local")
      .getOrCreate()
    
    //val conf = new SparkConf().setAppName("digitalmetering").setMaster("local[*]")

    
    
    //val sc: SparkContext = new SparkContext(conf)
    //val sqlContext: SQLContext = new SQLContext(sc)

    import spark.implicits._

    //val df = spark.read.csv("data/uniMelb.csv")
    //df.where($"rn" > 2)
    val newRow = records.toDF
    //val rdd = sc.parallelize(records)
    //val rowRdd = rdd.map(v => Row(v: _*))
    //val newRow = sqlContext.createDataFrame(rdd)
    //println(newRow.head(1).toString())
    newRow.take(1).foreach(println)
    spark.stop()
   
  }
}
