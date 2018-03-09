package chapter18.section1

/**
  * Created by zlq on 3/12/17.
  */
class Document {
  /*def setTitle(title: String): Document = {
    this
  }

  def setAuthor(author: String): Document = {
    this
  }*/

  def setTitle(title: String): this.type = {
    this
  }

  def setAuthor(author: String): this.type = {
    this
  }
}
