package chapter18.section14.v1

/**
  * Created by zlq on 3/12/17.
  */
trait Iterable[E] {
  def iterator(): Iterator[E]
  def map[F](f: (E) => F): Iterable[F]
}
