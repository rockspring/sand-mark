package chapter18.section2

/**
  * Created by zlq on 3/12/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val chatter = new Network
    val myFace = new Network

    val fred = chatter.join("Fred")
    val barney = myFace.join("Barney")

    //以下语句是错误的，类型不匹配
    //chatter.members += barney


    fred.contacts += barney
  }
}
