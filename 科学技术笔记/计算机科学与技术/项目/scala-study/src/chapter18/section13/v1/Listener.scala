package chapter18.section13.v1

/**
  * Created by zlq on 3/12/17.
  */
trait Listener[E] {
  def occurred(e: E): Unit
}
