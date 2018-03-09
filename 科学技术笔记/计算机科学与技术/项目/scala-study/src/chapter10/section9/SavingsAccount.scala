package chapter10.section9

/**
  * Created by zlq on 3/11/17.
  */
class SavingsAccount extends Account with ConsoleLogger with ShortLogger {
  val maxLength = 20
  var interest = 0.0

  def withdraw(amount: Double): Unit = {
    if (amount > balance) {
      log("Insufficient funds")
    } else {
      balance -= amount
    }
  }
}
