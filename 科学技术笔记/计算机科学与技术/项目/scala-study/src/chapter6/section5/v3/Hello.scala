package chapter6.section5.v3

/**
  * Created by zlq on 3/5/17.
  *
  * 所有带有该特质的类，其初始化方法都会被挪到delayedInit方法中。App特质的main方法捕获到命令行参数，调用delayedInit方法，并且还可以
  * 根据要求打印出逝去的时间
  */
object Hello extends App{
  if (args.length > 0) {
    println("Hello, " + args(0))
  } else {
    println("Hello, World!")
  }
}
