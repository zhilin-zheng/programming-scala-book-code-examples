//src/script/scala/progscala3/myplay/functions.scala
def do_something(verb:String, obj:String) = {
  println("verb is: " + verb)
  println("noun is: " + obj)
  println("phrase of verb is: " + verb + " " + obj)
}

val verb = "stop"
val obj = "talking"
do_something(verb, obj)
