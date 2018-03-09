package chapter10.section7

/**
  * Created by zlq on 3/11/17.
  */
class SavingsAccount extends Account with Logger {
  var balance:Double = 0

  def withdraw(amount: Double): Unit = {
    if (amount > balance) {
      severe("Insufficient funds")
    } else {
      balance -= amount
    }
  }

  override def log(msg: String): Unit = {
    println(msg)
  }
}
