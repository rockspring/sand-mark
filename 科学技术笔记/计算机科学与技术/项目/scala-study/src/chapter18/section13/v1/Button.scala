package chapter18.section13.v1

import java.awt.event.ActionEvent

/**
  * Created by zlq on 3/12/17.
  */
class Button extends Source[ActionEvent, ActionListener]{
  def click(): Unit ={
    fire(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "click"))
  }
}
