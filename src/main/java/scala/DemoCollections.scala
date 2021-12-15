package scala

import java.util

import scala.collection.mutable.ListBuffer

/**
 * @author Alexander Zero
 * @date 2021/12/14
 * @version 1.0.0
 */
object DemoCollections {

  def main(args: Array[String]): Unit = {
    //java中的集合, [] 表示泛型
    //    val listJava = new util.LinkedList[String]()
    //    listJava.add("hello")


    //数组 用(n) 取值, 赋值
    println("----------数组-----------")
    val arr01 = Array(1, 2, 3)
    arr01.foreach(println)
    println(arr01(2))
    arr01(2) = 44
    println(arr01(2))


    println("----------链表-----------")
    //Collection 分为 可变和不可变  mutable, immutable
    //不可变
    val list = List(1, 2, 4, 5, 6)
    list.foreach(println)
    //报错
    //list.++(5)
    println("-----------")
    //可变
    val list01 = new ListBuffer[Int]()
    list01.+=(1)
    list01.+=(2)
    list01.+=(3)

    val list02 = new ListBuffer[Int]()
    //.+=  向后添加
    list02.+=(11)
    list02.+=(22)
    list02.foreach(println)
    println("-----------")

    //.+=: 向前添加
    list02.+=:(44)
    list02.foreach(println)
    println("-----------")

    //添加到 addAll , list01变大
//    list02.++(list01)
//    list02.foreach(println)
//    list01.foreach(println)
//    println("-----------")

    // addAll list02变大
//    list02.++=(list01)
//    list01.foreach(println)
    //    list02.foreach(println)
//    println("-----------")

    //???
//    list02.++()
    list02.++:(list01)
    list01.foreach(println)
    list02.foreach(println)
    println("-----------")

    //    list02.++()
    //    list02.+()
    //    list02.++=:()
    //    list02.+=()

  }
}
