package scala

/**
 * @author Alexander Zero
 * @date 2021/12/15
 * @version 1.0.0
 *
 */

//有case关键字, 不需要再用new
//比较时使用的内部的值比较, 而不是引用比较


case class Human(name: String, age: Int) {}


object DemoCase {

  def main(args: Array[String]): Unit = {
    val h1: Human = new Human("zhangsan", 18)
    val h2: Human = new Human("zhangsan", 18)

    println(h1.equals(h2))
    println(h1 == h2)

  }
}
