package chapter17.section10

/**
  * Created by zlq on 3/11/17.
  */
class Pair[+T](val first: T, val second: T) {
  /**
    Error:(6, 7) covariant type T occurs in contravariant position in type T of value first_=
class Pair[+T](var first: T, var second: T) {

    Error:(6, 7) covariant type T occurs in contravariant position in type T of value second_=
class Pair[+T](var first: T, var second: T) {
    */
}
