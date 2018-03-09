package chapter17.section5

/**
  * Created by zlq on 3/11/17.
  */
class Pair[T : Ordering](val first: T, val second: T) {
  def smaller(implicit ord: Ordering[T]): T = {
    if (ord.compare(first, second) < 0) first else second
  }
}
