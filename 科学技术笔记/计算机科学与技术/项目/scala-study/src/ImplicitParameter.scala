/**
  * Created by zlq on 3/27/16.
  */

case class Delimiters(left: String, right: String)

object Delimiters {
  implicit val delimiters = new Delimiters(">", "<")
}


object ImplicitParameter {
  def quote(what: String)(implicit delims: Delimiters) =
    delims.left + what + delims.right

  def main(args: Array[String]) {
    //implicit val delimiters = new Delimiters("<", "<")
    //implicit val delimiters2 = new Delimiters("<", ">")
    //val quotedString = quote("机器学习")(Delimiters("<<", ">>"))
    val quotedString = quote("机器学习")
    println(quotedString)
  }
}
