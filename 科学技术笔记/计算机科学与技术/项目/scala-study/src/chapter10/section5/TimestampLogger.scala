package chapter10.section5

/**
  * Created by zlq on 3/11/17.
  */
trait TimestampLogger extends Logged{
  override def log(msg: String): Unit = {
    super.log(new java.util.Date() + " " + msg)
  }
}
