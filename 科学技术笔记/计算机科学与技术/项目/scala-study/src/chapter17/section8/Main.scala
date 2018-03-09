package chapter17.section8

/**
  * Created by zlq on 3/11/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val p = new Pair("a", "b")
    println(p.smaller)

    //以下语句无法编译
    //val p2 = new Pair(new Array[String](0), new Array[String](1));
  }
}
