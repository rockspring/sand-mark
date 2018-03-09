package tutorials.actor

import scala.actors.Actor

/**
  * Created by zlq on 4/8/16.
  */

case class Charge(creditCardNumber: Long, merchant: String, amount: Double) {

}
class ActorExample2 extends Actor{
  def act() {
    while (true) {
      receive {
        case Charge(ccnum, merchant, amt) => println("ccnum=" + ccnum +" merchant=" + merchant + " amt=" + amt)
      }
    }
  }
}

object ActorExample2 {
  def main(args: Array[String]) {
    val fraudControl = new ActorExample2;
    fraudControl.start()

    fraudControl ! Charge(411111111L, "Fred's Bait and Tackle", 19.95)
  }
}
