package chapter10.section4

/**
  * Created by zlq on 3/11/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    // 构造单个对象时，你可以为它添加特质
    val acct = new SavingsAccount with ConsoleLogger

    val acct2 = new SavingsAccount with FileLogger

    acct.withdraw(10.0)
    acct2.withdraw(108.8)
  }
}
