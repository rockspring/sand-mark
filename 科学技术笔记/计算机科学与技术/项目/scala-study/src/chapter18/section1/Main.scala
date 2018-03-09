package chapter18.section1

/**
  * Created by zlq on 3/12/17.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val article = new Document
    article.setTitle("a").setAuthor("b")

    val book = new Book
    book.setTitle("a").addChapter("10")
  }
}
