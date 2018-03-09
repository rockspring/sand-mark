package chapter10.section5


/**
  * Created by zlq on 3/11/17.
  */
class SavingsAccount extends Account with Logged {
  var balance:Double = 0

  def withdraw(amount: Double): Unit = {
    if (amount > balance) {
      log("Insufficient funds")
    } else {
      balance -= amount
    }
  }
}
