package chapter18.section1.subsection1

/**
  * Created by zlq on 3/12/17.
  */

object Title

class Document {
  private var title: String = ""
  private var useNextArgAs: Any = _

  def set(obj: Title.type ): this.type = {
    useNextArgAs = obj
    this
  }

  def to(arg: String): this.type = {
    if (useNextArgAs == Title) {
      title = arg
      this
    } else {
      this
    }
  }
}
