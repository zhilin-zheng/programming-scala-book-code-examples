// src/script/scala/progscala3/patternmatching/FragileAssignments.scala

val h4a +: h4b +: t4 = Seq(1,2,3,4) : @unchecked
val h2a +: h2b +: t2 = Seq(1,2) : @unchecked
val h1a +: h1b +: t1 = Seq(1) : @unchecked       // MatchError!

val h4a +: h4b +: t4 = Seq(1,2,3,4)
