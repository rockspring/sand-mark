package chapter17.section1

/**
  * Created by zlq on 3/11/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val p = new Pair(42, "String")
    val p2 = new Pair[Any, Any](42, "String")

    println(p.first + " => " + p.second)
    println(p2.first + " => " + p2.second)

  }
}
