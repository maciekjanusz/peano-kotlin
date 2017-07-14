package com.maciekjanusz

sealed class Nat {
    abstract fun isZero(): Boolean
    abstract fun predecessor(): Nat
    fun successor() = Succ(this)
    operator fun unaryPlus() = successor()
    operator fun unaryMinus() = predecessor()
    abstract operator fun plus(that: Nat): Nat
    abstract operator fun minus(that: Nat): Nat
    fun negativeError(): Nothing = throw RuntimeException("negative")
}

object Zero : Nat() {
    override fun isZero(): Boolean = true
    override fun predecessor() = negativeError()
    override fun plus(that: Nat) = that
    override fun minus(that: Nat) = if (that.isZero()) Zero else negativeError()
}

open class Succ(val pre: Nat) : Nat() {
    override fun isZero() = false
    override fun predecessor() = pre
    override fun plus(that: Nat) = Succ(pre + that)
    override fun minus(that: Nat) = if (that.isZero()) this else pre - that.predecessor()
}

object One : Succ(Zero)
class Two : Succ(One)
class Three : Succ(Two())

fun eval(n: Nat): Int = when (n) {
    Zero -> 0
    is Succ -> eval(n.pre) + 1
}

fun main(args: Array<String>) {
    val thirtyFour =
            Succ(Succ // 2
            (Succ(Succ // 4
            (Succ(Succ // 6
            (Succ(Succ // 8
            (Succ(Succ // 10
            (Succ(Succ // 12
            (Succ(Succ // 14
            (Succ(Succ // 16
            (Succ(Succ // 18
            (Succ(Succ // 20
            (Succ(Succ // 22
            (Succ(Succ // 24
            (Succ(Succ // 26
            (Succ(Succ // 28
            (Succ(Succ // 30
            (Succ(Succ // 32
            (Succ(Succ // 34
            (Zero))))))))))))))))))))))))))))))))))

    println(eval(One)) // 1
    println(eval(Two())) // 2
    println(eval(Three())) // 3
    println(eval(thirtyFour)) // 34

    // unary operator
    println(eval(+Zero)) // 1
}
