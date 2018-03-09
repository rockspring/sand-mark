/**
  * Created by zlq on 3/14/17.
  */
object TestScala {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setAppName("Datasets Test")
    conf.setMaster("local[2]")
    val sc = new SparkContext(conf)
    println(sc)
  }
}
