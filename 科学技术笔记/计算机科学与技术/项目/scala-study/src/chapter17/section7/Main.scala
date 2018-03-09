package chapter17.section7

/**
  * Created by zlq on 3/11/17.
  */
object Main {
  def smaller[T <: Comparable[T] with Serializable with Cloneable](first: T, second: T): T = {
    if (first.compareTo(second) < 0) first else second
  }

  def main(args: Array[String]): Unit = {
    //println(smaller("a", "b"))
  }
}
