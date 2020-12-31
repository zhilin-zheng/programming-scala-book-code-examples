// src/main/scala/progscala3/introscala/SayHello.scala
package progscala3.introscala

object SayHello:
  def main(params: Array[String]): Unit =
    printf("hello, I am ")
    params.map(s => s.toUpperCase()).foreach(s => printf("%s ",s))
    println("")
  end main

end SayHello
