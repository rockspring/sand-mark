package chapter6.section2

/**
  * Created by zlq on 3/5/17.
  */
object Account {
  private var lastNumber = 0

  /**
    * 对象的构造器在改对象第一次被使用时调用。
    * @return
    */
  private def newUniqueNumber() = {
    lastNumber += 1
    lastNumber
  }
}

class Account {
  /**
    * 类和它的伴生对象可以相互访问私有特性。但不在同一个作用域中。访问伴生对象的newUniqueNumber方法需要Account限定名。
    */
  val id: Int = Account.newUniqueNumber()
  private var balance = 0.0
  def deposit(amount: Double): Unit = {
    balance += amount
  }
}
