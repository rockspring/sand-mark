package chapter10.section8

/**
  * Created by zlq on 3/11/17.
  */
trait ConsoleLogger extends Logged{
  override def log(msg: String): Unit = {
    println(msg)
  }
}
