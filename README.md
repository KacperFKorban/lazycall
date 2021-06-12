# LazyCall

Tired of having to call right methods? Tired of having to know names of methods?

Buy do I have a thing for You.

```scala
import lazycall.*

case class XD(i: Int) {
  def a: Long = i.toLong
}

XD(1).magicTo[Long]
```