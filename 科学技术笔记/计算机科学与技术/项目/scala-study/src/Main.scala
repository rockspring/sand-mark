/**
  * Created by zlq on 3/26/16.
  */

class Pair[T](val first: T, val second: T) {
  def smaller(implicit ev: T <:< Ordered[T]) ={
    if (first < second) first else second
  }
  def test[T](i:T)(implicit ev: T <:< java.io.Serializable) {
    print("OK")
  }
}

object Main {
  def makePair[T : Manifest](first:T, second:T) = {
    val r = new Array[T](2)
    r(0) = first
    r(1) = second
    r
  }

  def main(args: Array[String]) {
    println("Hello, World!")

    val pair =makePair(1, 2)
    val pair2 = makePair("a", "b")

    val pair3 = new Pair(new Integer(3), new Integer(4))


    val friends = Map("Fred" -> "Barney")
    val friendOpt = friends.get("Fred")
    val friendOrNull = friendOpt.orNull

    println("end")
  }
}

class A[+T]
