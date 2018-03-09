package chapter10.section5

/**
  * Created by zlq on 3/11/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val acc1 = new SavingsAccount
    acc1.withdraw(3.5)

    val acc2 = new SavingsAccount with ConsoleLogger
    acc2.withdraw(6.8)

    // 叠加在一起的特质，方法调用的顺序与添加的顺序刚好相反
    // 先调用TimestampLogger的log方法，TimestampLogger的log方法再调用ConsoleLogger的log方法
    // 需要用super方法的方式才能传递调用
    val acc3 = new SavingsAccount with ConsoleLogger with TimestampLogger
    acc3.withdraw(7.9)

    val acc4 = new SavingsAccount with ConsoleLogger with ShortLogger
    acc4.withdraw(9.9)

    val acc5 = new SavingsAccount with ConsoleLogger with TimestampLogger with ShortLogger
    acc5.withdraw(6.6)
  }
}
