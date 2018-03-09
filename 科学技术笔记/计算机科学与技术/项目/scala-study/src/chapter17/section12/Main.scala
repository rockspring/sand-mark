package chapter17.section12

import java.util.Comparator

/**
  * Created by zlq on 3/11/17.
  */
object Main {
  def process(people: java.util.List[_ <: Person]): Unit = {

  }

  def makeFriends(p: Pair[_ <: Person]): Unit = {

  }

  def min[T](p: Pair[T])(comp: Comparator[_ >: T]): Unit = {

  }

  def main(args: Array[String]): Unit = {
    makeFriends(new Pair[Person](new Person, new Student))
  }
}
