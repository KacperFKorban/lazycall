import scala.quoted.*

object lazycall:

  extension [S](self: S)
    inline def magicGet[T]: T = ${magicGetImpl[S, T]('self)}

  def magicGetImpl[S: Type, T: Type](selfExpr: Expr[S])(using Quotes): Expr[T] =
    import quotes.reflect.*

    val resultType = TypeRepr.of[T]

    val methods = TypeRepr.of[S].typeSymbol.memberMethods.filter { (method: Symbol) =>
      val defdef = method.tree.asInstanceOf[DefDef]
      defdef.returnTpt.tpe =:= resultType
        && defdef.paramss.flatMap(_.params).isEmpty //TODO cnsider non empty lists (returning functions or sth)
    }

    methods match
      case List(method) =>
        Select(
          selfExpr.asTerm,
          method
        ).asExprOf[T]
      case _ =>
        report.throwError("No can do Amigo!")

  end magicGetImpl

end lazycall