package chapter18.section14.v2

/**
  * Created by zlq on 3/12/17.
  */
trait Iterable[E, C[_]] {
  def iterator(): Iterator[E]
  def build[F](): C[F]

  def map[F](f: (E) => F): C[F] = {
    val res = build[F]()
    val iter = iterator()
    while (iter.hasNext) {
      val next = f(iter.next())
      //res += next
    }
    res
  }
}
