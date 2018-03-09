package chapter10.section9

/**
  * Created by zlq on 3/11/17.
  */
trait ShortLogger extends Logged{
  val maxLength: Int

  override def log(msg: String): Unit = {
    super.log(if (msg.length <= maxLength) msg else msg.substring(0, maxLength-1))
  }
}
