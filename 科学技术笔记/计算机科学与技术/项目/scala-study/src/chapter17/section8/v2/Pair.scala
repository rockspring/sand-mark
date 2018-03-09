package chapter17.section8.v2

/**
  * Created by zlq on 3/11/17.
  */
class Pair[T](val first: T, val second: T) {
  def smaller(implicit ev : T <:< Ordered[T]):T = {
    if (first < second) first else second
  }
}
