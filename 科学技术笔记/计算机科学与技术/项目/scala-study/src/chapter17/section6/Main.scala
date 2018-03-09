package chapter17.section6

/**
  * Created by zlq on 3/11/17.
  */
object Main {
  def makePair[T : Manifest](first: T, second: T): Array[T] = {
    val r = new Array[T](2);
    r(0) = first
    r(1) = second
    r
  }

  def makePair2[T](first: T, second: T)(implicit m: Manifest[T]): Array[T] = {
    val r = new Array[T](2);
    r(0) = first
    r(1) = second
    r
  }

  def main(args: Array[String]): Unit = {
    val r = makePair(1, 3)
    println(r.length)

    val r2 = makePair2(1, 3)
    println(r2.length)
  }
}
