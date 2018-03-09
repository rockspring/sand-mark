package chapter18.section14.v1

/**
  * Created by zlq on 3/12/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val buffer = new Buffer[String]
    buffer.map(x => x)
    println(buffer)
  }
}
