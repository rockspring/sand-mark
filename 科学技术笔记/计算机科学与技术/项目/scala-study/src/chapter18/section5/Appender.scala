package chapter18.section5

/**
  * Created by zlq on 3/12/17.
  */
class Appender {
  def appendLines(target: {def append(str: String): Any}, lines: Iterable[String]): Unit = {
    for (l <- lines) {
      target.append(l)
      target.append("\n")
    }
  }
}
