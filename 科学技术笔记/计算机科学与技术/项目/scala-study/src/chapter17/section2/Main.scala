package chapter17.section2

/**
  * Created by zlq on 3/11/17.
  */

object Main {
  def getMiddle[T](a: Array[T]): T = a(a.length / 2)

  def main(args: Array[String]): Unit = {
    val middle = getMiddle(Array("Mary", "had", "a", "litter", "lamb"))

    println(middle)

    val f =getMiddle[String](Array("Mary", "had", "a", "litter", "lamb"))

    println(f)
  }

}
