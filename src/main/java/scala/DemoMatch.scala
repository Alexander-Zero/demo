package scala

/**
 * @author Alexander Zero
 * @date 2021/12/15
 * @version 1.0.0
 */
object DemoMatch {
  def main(args: Array[String]): Unit = {

    val t5: (Double, Int, String, String, Boolean) = (1.0, 88, "abc", "bcd", false)
    val iterator: Iterator[Any] = t5.productIterator

//    val result: Iterator[Unit] = iterator.map(x => {
//      x match {
//        case 1 => println(s"value is 1 :")
//        case y: Int => println(s"value is Int: $y")
//        case y:Boolean => println(s"value is boolean: $y")
//        case "abc" => println(s"value is abc: $x")
//        case w: String => println(s"value is String: $w")
//        case _ => println("I don't know what value it is!!")
//      }
//    })

    val result: Iterator[Unit] = iterator.map {
      case 1 => println("value is 1")
      case y: Int => println(s"value is Int: $y")
      case x@"abc" => println(s"value is String: $x")
      case x: Boolean => println(s"value is boolen: $x")
      case _ => println("I don't know what value it is")
    }



    //map 返回一个迭代器, 返回不执行,
    result.foreach(println)

  }

}
