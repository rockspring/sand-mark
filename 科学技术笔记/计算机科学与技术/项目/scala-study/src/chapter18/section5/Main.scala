package chapter18.section5

/**
  * Created by zlq on 3/12/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val strAppender = new StringAppender
    val appender = new Appender
    appender.appendLines(strAppender, Array("a", "b"))

    println(strAppender)
  }
}
