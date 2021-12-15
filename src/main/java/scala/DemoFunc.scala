package scala

/**
 * @author Alexander Zero
 * @date 2021/12/14
 * @version 1.0.0
 */
object DemoFunc {

  def main(args: Array[String]): Unit = {

    println("---------basic----------")

    def fun01(): Unit = {
      println("this is basic")
    }

    //方法必有返回值,若不写默认Unit,打印为 ()
    val unit = fun01()
    println(unit)

    //标明返回值, 使用= 加上返回值类型(可不填,可推断,建议填写)
    def fun02() = {
      3
    }

    val i = fun02()
    println(i)


    println("---------递归函数----------")

    //递归必须写返回值类型,否则无法推断
    def fun03(a: Int): Int = {
      if (a <= 1) {
        a
      } else {
        a * fun03(a - 1)
      }
    }

    val i1 = fun03(3)
    println(i1)

    val i2 = fun03(4)
    println(i2)


    println("---------默认值----------")

    def fun04(a: Int = 9, b: String = "hello"): Unit = {
      println(s"$a\t$b")
    }

    fun04()

    fun04(3)

    fun04(b = "you")


    println("---------匿名函数----------")
    //返回值类型可写可不写 (Int, Int) => Unit
    val fun05: (Int, Int) => Unit = (a: Int, b: Int) => {
      println(s" $a * $b = ${a * b}")
    }
    fun05(3, 4)


    println("---------嵌套函数----------")

    def fun06(s: String): Unit = {
      def fun06C(ss: String): Unit = {
        println(s"$s and $ss")
      }

      fun06C("xxoo")
    }

    fun06("ooxx")

    println("---------偏应用函数----------")

    def fun07(code: Int, data: String, msg: String): Unit = {
      println(s"code:$code\tdata:$data\tmsg:$msg")
    }

    val fun07Error = fun07(500, _: String, _: String)
    val fun07NotFound = fun07(404, _: String, _: String)

    fun07(200, "zhangsan", "操作成功")
    fun07Error("无", "错误")
    fun07NotFound("无", "找不到路径")


    println("---------可变参数----------")

    def fun08(a: Int*): Unit = {
      a.foreach(e => println(e))
      println("--------")
      a.foreach(println(_)) //只有一个参数可省略
      println("--------")
      a.foreach(println) //可直接传函数
    }

    fun08(11, 22, 33)


    println("---------高阶函数----------")

    //函数作为参数
    def computer(x: Int, y: Int, algo: (Int, Int) => Int): Int = {
      algo(x, y)
    }

    //函数作为返回值
    def computerFactory(notation: String): (Int, Int) => Int = {
      def plus(x: Int, y: Int): Int = {
        x + y
      }

      if (notation.equals("+")) {
        plus
      } else {
        (x: Int, y: Int) => {
          x * y
        }
      }

    }


    //减法
    val i3 = computer(10, 3, (a: Int, b: Int) => {
      a - b
    })
    println(i3)
    //加法
    val i4 = computer(10, 3, computerFactory("+"))
    println(i4)
    //乘法
    val i5 = computer(10, 3, computerFactory("*"))
    println(i5)


    println("---------柯里化----------")
    def fun09(a:Int*)(b:String*): Unit ={
      println(a)
      println(b)
      a.foreach(println)
      b.foreach(println)
    }

    fun09(1,2,3)("hello","world")




    println("---------其他----------")
    def funNoArgs1(): Int={
      println("fun no args 1")
      6
    }

    //空参函数,可省略(), 返回值会函数返回值, 若返回值为函数 空格 +　下划线
    val result = funNoArgs1
    println(result)

    println("-------------")
    val resultFunc = funNoArgs1 _
    println(resultFunc)


    println("---------basic----------")




  }


  def funNoArg(): Int ={
    println("no args method")
    4
  }
}
