package chapter10.section2.V2

import chapter10.section2.Logger

/**
  * Created by zlq on 3/11/17.
  */
class ConsoleLogger extends Logger with Cloneable with Serializable{
  // Scala解析时，首先把Logger with Cloneable with Serializable看做一个整体
  // ConsoleLogger是继承了上述整体特质
  def log(msg: String):Unit =  {
    println(msg)
  }
}
