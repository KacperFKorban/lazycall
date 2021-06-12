object Main extends App {

  import lazycall.*

  case class XD(i: Int) {
    def a: Long = i.toLong
  }

  println(XD(1).magicTo[Long])

}