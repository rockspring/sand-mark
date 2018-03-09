package chapter6.section4

/**
  * Created by zlq on 3/5/17.
  */

object Account {
  private var lastNumber = 0

  private def newUniqueNumber() = {
    lastNumber += 1
    lastNumber
  }

  /**
    * 通常会定义和使用对象的apply方法，返回的是伴生类的对象
    * 为什么不用构造器呢？对于嵌套表达式而言，省去new关键字会方便很多
    *
    * @param initialBalance 初始账户余额
    * @return
    */
  def apply(initialBalance: Double): Account = {
    new Account(newUniqueNumber(), initialBalance)
  }
}

/**
  * 私有化构造器
  * @param id
  * @param initialBalance
  */
class Account private (val id: Int, initialBalance: Double) {
  private var balance = initialBalance
}


