package chapter6.section4

/**
  * Created by zlq on 3/5/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    /**
      * 如下表达式会调用Array对象的apply方法，返回伴生类的对象
      */
    Array("Mary", "had", "a", "little", "lamb")

    /**
      * 为什么不用构造器呢？对于嵌套表达式而言，省去new关键字会方便很多
      */
    Array(Array(1, 7), Array(2, 9))

    val acct = Account(1000.0)

    println(acct.id)

    //new Account(100)
    /**
      * Error:(20, 5) not enough arguments for constructor Account: (id: Int, initialBalance: Double)chapter6.section4.Account.
Unspecified value parameter initialBalance.
    new Account(100)
      */
  }
}
