package chapter18.section13.v2

/**
  * Created by zlq on 3/12/17.
  */
trait Listener[S, E <: Event[S]] {
  def occurred(e: E): Unit
}
