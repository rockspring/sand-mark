package chapter17.section4

/**
  * Created by zlq on 3/11/17.
  */
class Pair[T <% Ordered[T]](val first: T, val second: T) {
  def smaller: T = if (first < second) first else second
}
