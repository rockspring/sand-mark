package chapter18.section13.v1
import java.awt.event.ActionEvent


/**
  * Created by zlq on 3/12/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val b = new Button
    b.add(new ActionListener {
      override def occurred(e: ActionEvent): Unit = {
        println(e)
      }
    })

    b.click()
  }
}
