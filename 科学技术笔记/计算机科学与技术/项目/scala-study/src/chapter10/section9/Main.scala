package chapter10.section9

/**
  * Created by zlq on 3/11/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val acc1 = new SavingsAccount
    acc1.withdraw(3.5)

    println(acc1.balance)
    println(acc1.interest)
    println(acc1.maxLength)
  }
}
