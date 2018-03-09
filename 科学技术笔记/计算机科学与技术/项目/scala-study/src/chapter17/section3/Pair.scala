package chapter17.section3

/**
  * Created by zlq on 3/11/17.
  */
class Pair[T <: Comparable[T]](val first: T, val second: T) {
  def smaller: T = if (first.compareTo(second) < 0) first else second
}
