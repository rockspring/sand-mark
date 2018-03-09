package chapter17.section11

/**
  * Created by zlq on 3/11/17.
  */
abstract class List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}
