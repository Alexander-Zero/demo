package scala

/**
 * @author Alexander Zero
 * @date 2021/12/15
 * @version 1.0.0
 */

trait Animal {
  def move(): Unit = {
    println("animal is moving")
  }
}

trait God {
  def pray(): Unit = {
    println("God  will help you !!")
  }
}

trait Demon{
  def kill(): Unit ={
    println("demon is killing people!!")
  }
}

class Person(name:String) extends God with Animal with Demon {
  def sayHello(): Unit ={
    println(s"$name say hello!!")
  }

}


object DemoTrait {

  def main(args: Array[String]): Unit = {
    val joe: Person = new Person("Joe")
    joe.sayHello()
    joe.move()
    joe.pray()
    joe.kill()

  }
}
