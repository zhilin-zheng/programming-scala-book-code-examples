// src/main/scala/progscala3/appdesign/dbc/ElidableExample.scala
package progscala3.appdesign.dbc

import scala.annotation.elidable._
import scala.annotation.elidable

/**
 * Compile outside sbt using the scala compiler:
 * ```
 * $ mkdir -p N
 * $ scalac -d N -Xelide-below N src/main/scala/progscala3/appdesign/dbc/ElidableExample.scala
 * $ scala -classpath N progscala3.appdesign.dbc.TryMyLogger
 * ```
 * for each N: WARNING, INFO, and ASSERTION
 */
object MyLogger:
  @elidable(WARNING)
  def warn(message: String) = println(s"WARNING:        $message")
  @elidable(INFO)
  def info(message: String) = println(s"INFO:           $message")
  @elidable(ASSERTION)
  def assertion(message: String) = println(s"ASSERTION: $message")

@main def TryMyLogger =
  MyLogger.warn("warn")
  MyLogger.info("info")
  MyLogger.assertion("assertion")
