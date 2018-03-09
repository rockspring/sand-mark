package chapter10.section3

/**
  * Created by zlq on 3/11/17.
  */
trait ConsoleLogger {
  // 特质中的方法并不一定是抽象的
  def log(msg: String): Unit = {
    println(msg)
  }
}
