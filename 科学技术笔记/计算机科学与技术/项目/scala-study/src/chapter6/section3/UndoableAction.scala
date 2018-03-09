package chapter6.section3

/**
  * Created by zlq on 3/5/17.
  *
  * 一个object可以扩展类及一个或多个特质，其结果是一个扩展了指定类以及特质的类的对象
  *
  * 将两步合成了一步，第一步是一个类扩展另一个类，第二步是创建扩展后的类的对象
  */
abstract class UndoableAction(val description: String) {
  def undo() : Unit
  def redo() : Unit
}
