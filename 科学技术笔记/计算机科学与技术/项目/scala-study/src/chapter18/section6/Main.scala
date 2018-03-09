package chapter18.section6

import java.awt.Rectangle
import java.awt.geom.Area

import scala.collection.mutable.ArrayBuffer

/**
  * Created by zlq on 3/12/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val image = new ArrayBuffer[java.awt.Shape with java.io.Serializable]()

    val image2 = new ArrayBuffer[java.awt.Shape with java.io.Serializable {}]()

    val rect = new Rectangle(5, 10, 20, 30)
    image += rect

    //image += new Area(rect)

    val image3 = new ArrayBuffer[java.awt.Shape with Serializable {def contains(p: java.awt.Point): Boolean}]()

    val image4 = new ArrayBuffer[java.awt.Shape with Serializable with AnyRef {def contains(p: java.awt.Point): Boolean}]()
  }
}
