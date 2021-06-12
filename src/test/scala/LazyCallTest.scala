class LazyCallTest extends munit.FunSuite {
  test("basic magicTo call") {
    import lazycall.*

    case class XD(i: Int) {
      def a: Long = i.toLong
    }

    val res = XD(1).magicTo[Long]
    assertEquals(res, 1.toLong)
  }
}