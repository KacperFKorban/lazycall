import scala.quoted.*

object lazycall:

  extension [S](self: S)
    inline def magicTo[T]: T = ${lazyToImpl[S, T]('self)}

  def lazyToImpl[S: Type, T: Type](selfExpr: Expr[S])(using Quotes): Expr[T] =
    import quotes.reflect.*

    val resultType = TypeRepr.of[T]

    val methods = TypeRepr.of[S].typeSymbol.memberMethods.filter { (method: Symbol) =>
      val defdef = method.tree.asInstanceOf[DefDef]
      defdef.returnTpt.tpe =:= resultType
        && defdef.paramss.flatMap(_.params).isEmpty //TODO cnsider non empty lists (returning functions or sth)
    }.head

    Select(
      selfExpr.asTerm,
      methods
    ).asExprOf[T]

  end lazyToImpl

end lazycall