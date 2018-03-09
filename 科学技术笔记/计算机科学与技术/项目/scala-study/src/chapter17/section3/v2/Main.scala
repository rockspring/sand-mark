package chapter17.section3.v2

/**
  * Created by zlq on 3/11/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val p = new Pair[String]("Fred", "Brooks")
    println(p.replaceFirst("zhou").first)
  }
}
