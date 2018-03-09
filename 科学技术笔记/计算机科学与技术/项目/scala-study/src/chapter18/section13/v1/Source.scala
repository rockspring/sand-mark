package chapter18.section13.v1

import scala.collection.mutable.ArrayBuffer

/**
  * Created by zlq on 3/12/17.
  */
trait Source[E, L <: Listener[E]] {
  private val listeners = new ArrayBuffer[L]()
  def add(l: L): Unit = {
    listeners += l
  }

  def remove(l: L): Unit = {
    listeners -= l
  }

  def fire(e: E): Unit = {
    for (l <- listeners) {
      l.occurred(e)
    }
  }
}
