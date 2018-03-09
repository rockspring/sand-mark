package chapter6.section6.v2

import chapter6.section6.TrafficLightColor.Value

/**
  * Created by zlq on 3/5/17.
  */
object TrafficLightColor extends Enumeration{
  val Red = Value(0, "Stop")
  val Yellow = Value(10)
  val Green = Value("Go")
}
