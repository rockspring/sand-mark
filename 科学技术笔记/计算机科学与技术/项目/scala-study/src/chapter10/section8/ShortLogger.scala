package chapter10.section8

/**
  * Created by zlq on 3/11/17.
  */
trait ShortLogger extends Logged{
  val maxLength = 15
  override def log(msg: String): Unit = {
    super.log(if (msg.length <= maxLength) msg else msg.substring(0, maxLength-1))
  }
}
