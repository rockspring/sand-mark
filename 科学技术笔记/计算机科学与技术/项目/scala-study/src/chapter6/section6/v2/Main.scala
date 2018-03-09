package chapter6.section6.v2

/**
  * Created by zlq on 3/5/17.
  */
object Main {

  /**
    * 记住，枚举的类型是TrafficLightColor.Value，而不是TrafficLightColor。后者是握有这些值的对象，相当于一个枚举值容器。
    * @param color
    * @return
    */
  def doWhat(color: TrafficLightColor.Value): String = {
    if (color == TrafficLightColor.Red) "stop"
    else if(color == TrafficLightColor.Yellow) "hurry up"
    else "go"
  }

  def main(args: Array[String]): Unit = {
    for (c <- TrafficLightColor.values) println(c.id + ":" + c)

    var whatTodo = doWhat(TrafficLightColor.Yellow)
    println(whatTodo)

    whatTodo = doWhat(TrafficLightColor(0))
    println(whatTodo)

    whatTodo = doWhat(TrafficLightColor.withName("Go"))
    println(whatTodo)
  }
}
