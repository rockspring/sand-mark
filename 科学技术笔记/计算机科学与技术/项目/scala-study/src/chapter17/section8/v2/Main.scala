package chapter17.section8.v2

/**
  * Created by zlq on 3/11/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val p = new Pair(new Array[String](0), new Array[String](1))
    //以下语句不能编译
    //p.smaller
  }
}
