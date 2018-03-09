package chapter18.section14.v1

/**
  * Created by zlq on 3/12/17.
  */
class Buffer[E] extends Iterable[E]{
  override def iterator(): Iterator[E] = {
    null
  }

  override def map[F](f: (E) => F): Buffer[F] ={
    new Buffer[F]()
  }
}
