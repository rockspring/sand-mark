package chapter18.section13.v2

/**
  * Created by zlq on 3/12/17.
  */
trait Event[S] {
  var source: S = _
}
