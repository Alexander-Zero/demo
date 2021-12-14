package scala

/**
 * @author Alexander Zero
 * @date 2021/12/14
 * @version 1.0.0
 *          流程控制语句
 */
object DemoFor {

  def main(args: Array[String]): Unit = {

    //-----------if-------------
    println()
    println()
    println("----------------if-----------------")
    var a = 3
    if (a <= 0) {
      println(s"a小于等于O,a为$a")
    } else {
      println(s"a大于0,a为$a")
    }


    //-----------while-------------
    println()
    println()
    println("----------------while-----------------")
    var b = 0
    while (b < 10) {
      println(b)
      b += 1
    }


    //-----------for-------------
    println()
    println()
    println("----------------for-----------------")

    //1 到 9 包括9
    val seq = 1 to 9
    println(seq)

    //步长为2
    val inclusive = 1 to(9, 2)
    println(inclusive)

    //1 到 9 不包括9
    val range = 1 until 9
    println(range)

    //打印九九乘法表
    //双层循环, 守卫
    for (i <- 1 to 9; j <- 1 until 10 if j <= i) {
      print(s"$i * $j = ${i * j} \t")
      if (i == j) println()
    }

    //收集数据, 将最后一行的数据收到到一个集合中,关键字 yield
    println("收集的数据")
    val ints = for (i <- 1 to 9; j <- 1 until 10 if j <= i) yield {
      i * j
    }
    println(ints)

  }
}
