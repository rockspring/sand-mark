package chapter17.section3.v3

/**
  * Created by zlq on 3/11/17.
  */
class Pair[T](val first: T, val second: T) {
  def replaceFirst[R >: T](newFirst: R) = new Pair[R](newFirst, second)
}
