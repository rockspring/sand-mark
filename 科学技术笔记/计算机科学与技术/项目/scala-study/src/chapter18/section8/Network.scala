package chapter18.section8

import scala.collection.mutable.ArrayBuffer

/**
  * Created by zlq on 3/12/17.
  */
class Network {
  class Member(val name: String) {
    //Network#Member，任何Network实例的Member
    val contacts = new ArrayBuffer[Member]()
  }

  val members = new ArrayBuffer[Member]()

  def join(name: String): Member = {
    val m = new Member(name)
    members += m
    m
  }
}
