package scala

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Alexander Zero
 * @date 2021/12/15
 * @version 1.0.0
 */
object WordCountScala {

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf()
    conf.setAppName("word-count-scala")
    conf.setMaster("local")

    val sc: SparkContext = new SparkContext(conf)

    // hello world
    // hello spark
    val rdd: RDD[String] = sc.textFile("data/data.txt")

    // hello
    // word
    // hello
    // spark
    val rddWord: RDD[String] = rdd.flatMap(x => x.split(" "))

    //hello 1
    //word 1
    //hello 1
    //spark 1
    val rddPair: RDD[(String, Int)] = rddWord.map(x => (x, 1))

    //hello 2
    //word 1
    //spark 1
    val result: RDD[(String, Int)] = rddPair.reduceByKey((x, y) => x + y)

    //执行
    result.foreach(println)



    //简写
    sc.textFile("data/data.txt").flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).foreach(println)


  }
}
