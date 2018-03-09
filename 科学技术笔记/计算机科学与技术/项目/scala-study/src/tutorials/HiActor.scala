package tutorials

import scala.actors.Actor
import scala.actors.Actor._;

/**
  * Created by zlq on 4/8/16.
  */
class HiActor extends Actor{
  def act() {
    while (true) {
      receive {
        case "Hi" => println("Hello")
      }
    }
  }
}

/*object Main {

  def main(args: Array[String]) {
    val actor1 = new HiActor
    actor1.start()

    val actor2 = actor({
      while (true) {
        receive {
          case "Hi" => println("Hello from actor2")
        }
      }
    })

    actor1 ! "Hi"
    actor2 ! "Hi"
  }
}*/
