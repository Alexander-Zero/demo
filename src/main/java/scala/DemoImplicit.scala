package scala

import scala.collection.mutable.ListBuffer

/**
 * @author Alexander Zero
 * @date 2021/12/15
 * @version 1.0.0
 */
object DemoImplicit {

  def main(args: Array[String]): Unit = {

    val list: ListBuffer[Int] = new ListBuffer()
    list.+=(1)
    list.+=(2)
    list.+=(3)

    //需求,再list中调用customForeach方法
    //list.customForeach(println)


    //1,第一种尝试, 能调用customForeach,但不能点出
    //    def customForeach(list: ListBuffer[Int], f: Any => Unit): Unit = {
    //      list.map(_ * 10).foreach(f)
    //    }
    //
    //    customForeach(list, println)


    //2, 第二种尝试, 创建一个类, 然后将new出类,调用
    //    val custom: Custom = new Custom(list)
    //    custom.customForeach(println)


    //3, 使用Implicit关键字 隐式方法
    //    implicit def anyMethodName[T](list: ListBuffer[T]) = {
    //      new XXOO[T](list)
    //    }
    //    list.customForeach(println)


    //4,隐式类, 直接写个类
    //    implicit class OOXX[T](list: ListBuffer[T]) {
    //      def customForeach(f: Any => Unit): Unit = {
    //        list.map(_ + "XXOO").foreach(f)
    //      }
    //    }
    //    list.customForeach(println)


    //5,隐式参数
    implicit val zs = "LISHI"
    implicit val zs2 = 15

    def sayHi(implicit name: String, age: Int): Unit = {
      println(s"$name age is  $age")
    }

    sayHi("张三", 13)
    sayHi

    //implicit 一定要放在后面
    def sayWord(name: String)(implicit age: Int): Unit = {
      println(s"$name say his age is $age")
    }

    sayWord("张山")
    sayWord("hsq")(15)
  }
}

class XXOO[T](list: ListBuffer[T]) {
  def customForeach(f: Any => Unit): Unit = {
    list.map(_ + "XXOO").foreach(f)
  }
}