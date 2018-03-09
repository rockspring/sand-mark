package chapter18.section8

import javax.swing.JComponent

import sun.tools.jconsole.{AboutDialog, JConsole}

import scala.collection.immutable.HashMap

/**
  * Created by zlq on 3/12/17.
  */
object Main {
  def proccess[M <: n.Member forSome {val n: Network}](m1: M, m2: M) = {
    (m1, m2)
  }

  def proccess2[M <: n.Member forSome {val n: Network}](m1: M, m2: M) = {
    (m1, m2)
  }

  def main(args: Array[String]): Unit = {
    val a: Array[T] forSome {type T <: JComponent} = new Array[AboutDialog](1)

    val b: Array[_] = new Array[Int](1)

    val c: Array[T] forSome {type T} = new Array[Int](1)

    val d: Map[_,_] = new HashMap[String, Int]

    val e: Map[T, U] forSome {type T; type U} = new HashMap[String, Int]

    val f: Map[T, U] forSome {type T; type U <: T} = new HashMap[String, String]

    //val n = new Network
    val network = new Network
    val member = network.join("Fred")
    //val g: (n.Member forSome {val n: Network}) = member

    val chatter = new Network
    val myFace = new Network
    val fred = chatter.join("Fred")
    val wilma = chatter.join("Wilma")
    val barney = myFace.join("Barney")

    val result = proccess(fred, wilma)
    //proccess(fred, barney)
    println(result)
  }
}
