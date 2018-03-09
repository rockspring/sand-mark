package chapter10.section4

/**
  * Created by zlq on 3/11/17.
  */
trait FileLogger extends Logged{
  override def log(msg: String): Unit = {
    println(msg)
  }
}
