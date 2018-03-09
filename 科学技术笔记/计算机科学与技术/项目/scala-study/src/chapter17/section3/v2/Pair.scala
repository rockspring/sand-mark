package chapter17.section3.v2

/**
  * Created by zlq on 3/11/17.
  */
class Pair[T](val first: T, val second: T) {
  def replaceFirst(newFirst: T) = new Pair[T](newFirst, second)
}
