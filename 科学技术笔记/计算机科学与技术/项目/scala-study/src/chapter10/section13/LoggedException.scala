package chapter10.section13

/**
  * Created by zlq on 3/11/17.
  */
trait LoggedException extends Logged{
  /*this: Exception => override def log(msg: String): Unit = {
    log(getMessage)
  }*/

  this: {def getMessage(): String} => override def log(msg: String): Unit = {
    super.log(getMessage)
  }
}
