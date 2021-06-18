class LazyCallTest extends munit.FunSuite {
  test("basic magicGet call") {
    import lazycall.*

    case class XD(i: Int) {
      def a: Long = i.toLong
    }

    val res = XD(1).magicGet[Long]
    assertEquals(res, 1.toLong)
  }

  test("ambiguous magicGet call") {
    val errors = compileErrors("""
      import lazycall.*

      case class XD(i: Int) {
        def a: Long = i.toLong
        def b: Long = i.toLong
      }

      XD(1).magicGet[Long]
    """)
    assert(errors contains "No can do Amigo!")
  }
}