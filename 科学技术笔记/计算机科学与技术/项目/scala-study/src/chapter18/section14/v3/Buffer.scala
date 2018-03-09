package chapter18.section14.v3

/**
  * Created by zlq on 3/12/17.
  */
/*class Buffer[E : Manifest] extends Iterable[E, Buffer] with Container[E] {
  private var capacity = 10
  private var length = 0
  private var elems = new Array[E](capacity)

  override def iterator() = new Iterator[E] {
    private var i = 0

    override def hasNext: Boolean = {
      i < length
    }

    override def next(): E = {
      i += 1
      elems(i-1)
    }
  }

  def build[F: Manifest]() = new Buffer[F]

  override def +=(e: E): Unit ={
    if (length == capacity) {
      capacity = 2 * capacity
      val nelems = new Array[E](capacity)
      for (i <- 0 until length) {
        nelems(i) = elems(i)
      }
      elems = nelems
    }

    elems(length) = e
    length += 1
  }
}*/
