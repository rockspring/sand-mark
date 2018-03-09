package chapter10.section2

/**
  * Created by zlq on 3/11/17.
  */
class ConsoleLogger extends Logger { // 用extends，而不是implements

  // 不需要写override
  def log(msg: String): Unit = {
    println(msg)
  }
}
