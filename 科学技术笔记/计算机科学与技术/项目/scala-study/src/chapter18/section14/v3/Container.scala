package chapter18.section14.v3

/**
  * Created by zlq on 3/12/17.
  */
trait Container[E] {
  def +=(e: E): Unit
}
