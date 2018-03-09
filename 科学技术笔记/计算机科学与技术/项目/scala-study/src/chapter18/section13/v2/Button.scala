package chapter18.section13.v2


/**
  * Created by zlq on 3/12/17.
  */
class Button extends Source[Button, ButtonEvent, ButtonListener]{
  def click(): Unit = {
    fire(new ButtonEvent)
  }
}
