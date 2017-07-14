package com.maciekjanusz

object One : Succ(Zero)
class Two : Succ(One)
object Three : Succ(Two())

object App {

    @JvmStatic
    fun main(args: Array<String>) {
        val thirtyFour = Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ
        (Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Succ(Zero))))))))))))))))))))))))))))))))))

        println(One.eval())
        println(Two().eval())
        print(Three.eval())
        println(thirtyFour.eval())
    }
}