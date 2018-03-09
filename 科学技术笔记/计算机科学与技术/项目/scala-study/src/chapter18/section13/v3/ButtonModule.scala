package chapter18.section13.v3

/**
  * Created by zlq on 3/12/17.
  */
object ButtonModule extends ListenerSupport{
  type S = Button
  type E = ButtonEvent
  type L = ButtonListener

  class ButtonEvent extends Event {
    override def toString: String = {
      "ButtonEvent"
    }
  }

  trait ButtonListener extends Listener

  class Button extends Source {
    def click(): Unit = {
      fire(new ButtonEvent)
    }
  }
}
