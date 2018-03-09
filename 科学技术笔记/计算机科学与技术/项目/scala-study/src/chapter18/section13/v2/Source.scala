package chapter18.section13.v2

import scala.collection.mutable.ArrayBuffer

/**
  * Created by zlq on 3/12/17.
  */
trait Source[S, E <: Event[S], L <: Listener[S, E]] {
  this: S =>
    private val listeners = new ArrayBuffer[L]()
    def add(l: L): Unit = {
      listeners += l
    }

    def remove(l: L): Unit = {
      listeners -= l
    }

    def fire(e: E): Unit = {
      e.source = this
      for (l <- listeners) {
        l.occurred(e)
      }
    }
}
