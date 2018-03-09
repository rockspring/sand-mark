package chapter10.section7

/**
  * Created by zlq on 3/11/17.
  */
trait Logger {
  def log(msg: String)
  def info(msg: String): Unit = {
    log("INFO: " + msg)
  }

  def warn(msg: String): Unit = {
    log("WARN: " + msg)
  }

  def severe(msg: String): Unit = {
    log("SEVERE: " + msg)
  }
}
