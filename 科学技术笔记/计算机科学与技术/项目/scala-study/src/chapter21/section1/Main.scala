package chapter21.section1

/**
  * Created by zlq on 3/12/17.
  */
object Main {
  implicit def int2Fraction(n: Int): Fraction = new Fraction(n, 1)

  def main(args: Array[String]): Unit = {
    val result = 3 * new Fraction(4, 5)
  }
}
