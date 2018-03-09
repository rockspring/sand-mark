package chapter18.section14.v3

/**
  * Created by zlq on 3/12/17.
  */
trait Iterable[E, C[X] <: Container[X]] {
  def build[F](): C[F]
  def iterator(): Iterator[E]

  def map[F](f: (E) => F): C[F]
}
