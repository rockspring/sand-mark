package chapter18.section5

/**
  * Created by zlq on 3/12/17.
  */
class StringAppender {
  var line: String = ""
  def append(str: String): Unit = {
    line += str
  }

  override def toString: String = {
    line
  }
}
