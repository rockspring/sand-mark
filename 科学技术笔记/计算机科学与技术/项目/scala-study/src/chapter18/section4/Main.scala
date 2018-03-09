package chapter18.section4

/**
  * Created by zlq on 3/12/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val book = new Book
    val index = new book.Index

    val book2 = new Book
    var index2 = new book.Index
    index2 = index
  }
}
