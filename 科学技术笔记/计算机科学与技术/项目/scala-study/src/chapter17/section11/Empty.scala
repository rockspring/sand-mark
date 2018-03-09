package chapter17.section11

/**
  * Created by zlq on 3/11/17.
  */
object Empty extends List[Nothing]{
  override def isEmpty: Boolean = true

  override def head: Nothing = throw new UnsupportedOperationException

  override def tail: List[Nothing] = throw new UnsupportedOperationException
}
