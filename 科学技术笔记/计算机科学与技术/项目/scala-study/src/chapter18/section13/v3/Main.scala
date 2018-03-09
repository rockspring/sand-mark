package chapter18.section13.v3

/**
  * Created by zlq on 3/12/17.
  */
object Main {
  import ButtonModule._

  def main(args: Array[String]): Unit = {
    val b = new Button
    b.add(new ButtonListener {
      override def occurred(e: ButtonEvent): Unit = {
        println(e)
      }
    })

    b.click()
  }
}
