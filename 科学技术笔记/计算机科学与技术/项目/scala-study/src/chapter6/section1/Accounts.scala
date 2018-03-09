package chapter6.section1

/**
  * Created by zlq on 3/5/17.
  */
object Accounts {
  private var lastNumber = 0

  /**
    * 对象的构造器在改对象第一次被使用时调用。
    * @return
    */
  def newUniqueNumber():Int = {
    lastNumber += 1
    lastNumber
  }
}
