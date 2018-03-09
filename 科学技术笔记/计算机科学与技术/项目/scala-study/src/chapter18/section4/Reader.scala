package chapter18.section4

/**
  * Created by zlq on 3/12/17.
  */
abstract class Reader {
  type Contents
  def read(fileName: String): Contents
}
