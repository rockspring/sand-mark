package chapter17.section11

/**
  * Created by zlq on 3/11/17.
  */
class Node[T](val head: T, val tail: List[T]) extends List[T]{
  override def isEmpty = false
}
