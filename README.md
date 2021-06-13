# LazyCall

Tired of having to call right methods? Tired of having to know names of methods?
Do You often find Yourself looking at Your code and thinking that it is too nice and readable?
Are You worried that Your employer will fire you and someone else will maintain Your code?

Boy do I have a thing for You.

```scala
import lazycall.*

case class XD(i: Int) {
  def a: Long = i.toLong
}

XD(1).magicGet[Long]
```

Disclaimer: The work `lazy` in name has nothing to do with the way methods are called. It only describes the state of mind of potential user.
