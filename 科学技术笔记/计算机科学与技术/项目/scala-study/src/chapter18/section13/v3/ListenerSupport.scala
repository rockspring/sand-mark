package chapter18.section13.v3

import scala.collection.mutable.ArrayBuffer

/**
  * Created by zlq on 3/12/17.
  */
trait ListenerSupport {
  type S <: Source
  type E <: Event
  type L <: Listener

  trait Event {
    var source: S = _
  }

  trait Listener {
    def occurred(e: E): Unit
  }

  trait Source {
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
}
