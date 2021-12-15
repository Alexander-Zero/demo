package scala

/**
 * @author Alexander Zero
 * @date 2021/12/14
 * @version 1.0.0
 */
object Demo1 {

  println("object before")

  val name = "object:zhangsan"
  private val demo = new Demo1(15)

  def main(args: Array[String]): Unit = {
    println("hello world")
    demo.sayHello()

  }


  println("object after")
}

//类名构造器: sex为Demo1的属性了,默认是private 和 val,但可以是var
//形参只有类名构造器中可以为var,其他的都是val
//裸露代码 可以理解为 在构造器中的代码,个性化构造必须调用其他构造,最终都会调用默认构造
//object 代表 单例,static, class 代表原型, 若需共享数据,使用伴生关系, class 和 object 名相同
//使用 ${Demo1.name}取值
//scala文件名只是一个载体, 重要的是文件名的 object或 class的命名, 若两个文件中有相同命名会报错
class Demo1(sex: String) {
  println("class before")

  val name = "class:lishi"


  def this(age: Int) {
    this("male")
    println(s"age is $age")
  }

  def sayHello(): Unit = {
    println("hello")
  }

  println(s"name is ${Demo1.name}")

  println(s"sex is $sex")

  println("class after")

}