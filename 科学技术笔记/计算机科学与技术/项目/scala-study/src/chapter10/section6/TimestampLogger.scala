package chapter10.section6

/**
  * Created by zlq on 3/11/17.
  */
trait TimestampLogger extends Logger{
  //重写抽象方法
  /*override def log(msg: String): Unit = {
    super.log(new java.util.Date() + " " + msg) // super.log方法定义了吗？
  }*/

  // 依然是抽象的
  abstract override def log(msg: String): Unit = {
    super.log(new java.util.Date() + " " + msg) // super.log方法定义了吗？
  }
}
