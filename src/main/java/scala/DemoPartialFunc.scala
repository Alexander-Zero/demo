package scala

/**
 * @author Alexander Zero
 * @date 2021/12/15
 * @version 1.0.0
 */
object DemoPartialFunc {
  def main(args: Array[String]): Unit = {

    //                     入参类型,出参类型
    def test: PartialFunction[Any, String] = {
      case "hello" => "hello world"
      case "zhansan" => "yes, i am zhangsan"
      case 1 => "I just a Integer, the one of the mins"
      case _ => "who am i??"
    }

    println(test("hello"))
    println(test(1))
    println(test(true))

  }

}
