package chapter18.section7

import scala.collection.immutable.HashMap
import scala.collection.mutable

/**
  * Created by zlq on 3/12/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    //var map = new String Map Int
    type x[String, Int] = (String, Int)
    val map = new x[String, Int]("a", 1)
    println(map)

    val map2 = new (String x Int)("b", 5)
    println(map2)

    var map3: (String HashMap Int) = new (String HashMap Int)
    map3 += new (String, Int)("a", 10)
    println(map3)
  }
}
