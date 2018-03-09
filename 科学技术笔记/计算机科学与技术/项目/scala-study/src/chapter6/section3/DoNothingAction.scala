package chapter6.section3

/**
  * Created by zlq on 3/5/17.
  */
object DoNothingAction extends UndoableAction("Do nothing") {
  override def undo() : Unit = {}
  override def redo() : Unit = {}
}
