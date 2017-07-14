package com.maciekjanusz

sealed class Nat {
    abstract fun isZero(): Boolean
    abstract fun predecessor(): Nat
    abstract operator fun plus(that: Nat): Nat
    abstract operator fun minus(that: Nat): Nat
    fun negativeError(): Nothing = throw RuntimeException("negative")
    abstract fun eval(): Int
}

object Zero : Nat() {
    override fun isZero(): Boolean = true
    override fun predecessor() = negativeError()
    override fun plus(that: Nat) = that
    override fun minus(that: Nat) = if (that.isZero()) Zero else negativeError()
    override fun eval() = 0
}

open class Succ(val pre: Nat) : Nat() {
    override fun isZero() = false
    override fun predecessor() = pre
    override fun plus(that: Nat) = Succ(pre + that)
    override fun minus(that: Nat) = if (that.isZero()) this else pre - that.predecessor()
    override fun eval() = pre.eval() + 1
}


