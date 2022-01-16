package com.example.kotlin_java_practicalss
interface A{
    fun dispA()

    fun letters() {
        println("From Interface A")
    }
}
interface B{
    fun dispB()

    fun letters() {
        println("From Interface B")
    }
}
class C: A, B {
    override fun dispA() {
        println("Method of interface A is called..")
    }

    override fun dispB() {
        println("Method of interface B is called")
    }

    override fun letters() {
        //println("From Class c")
        super<A>.letters()                  //It will call letters method from interface A
        //super<B>.letters()                //It will call letters method from interface B
    }
}

fun main() {
    var objC = C()
    objC.dispA()
    objC.dispB()
    objC.letters()
}