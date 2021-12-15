package scala;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Alexander Zero
 * @version 1.0.0
 * @date 2021/12/15
 */
public class WordCountJava {
    public static void main(String[] args) {
        final SparkConf conf = new SparkConf();
        conf.setAppName("word-count-java");
        conf.setMaster("local");

        final JavaSparkContext jsc = new JavaSparkContext(conf);
        final JavaRDD<String> rdd = jsc.textFile("data/data.txt");
        final JavaRDD<String> rddWord = rdd.flatMap(new FlatMapFunction<String, String>() {
            public Iterator<String> call(String line) throws Exception {
                return Arrays.asList(line.split(" ")).iterator();
            }
        });
        final JavaPairRDD<String, Integer> rddPair = rddWord.mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String, Integer>(s, 1);
            }
        });

        final JavaPairRDD<String, Integer> result = rddPair.reduceByKey(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer oldValue, Integer newValue) throws Exception {
                return oldValue + newValue;
            }
        });

        result.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            public void call(Tuple2<String, Integer> t2) throws Exception {
                System.out.println(t2._1 + "  " + t2._2);
            }
        });


        //简写
        jsc.textFile("data/data.txt").flatMap(new FlatMapFunction<String, String>() {
            public Iterator<String> call(String line) throws Exception {
                return Arrays.asList(line.split(" ")).iterator();
            }
        }).mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String, Integer> call(String word) throws Exception {
                return new Tuple2<String, Integer>(word,1);
            }
        }).reduceByKey(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer oldVal, Integer newVal) throws Exception {
                return oldVal+newVal;
            }
        }).foreach(new VoidFunction<Tuple2<String, Integer>>() {
            public void call(Tuple2<String, Integer> t2) throws Exception {
                System.out.println(t2._1 + "  "+ t2._2);
            }
        });


    }
}
