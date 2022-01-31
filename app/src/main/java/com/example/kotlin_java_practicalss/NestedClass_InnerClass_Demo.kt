package com.example.kotlin_java_practicalss

class Outer1 {
    var msg: String = "Hello from outer class"
    class Nested {
        fun nestedFun() {
            //var s:String = msg //invalid statement(we can't access member of outer class in nested one
             println("Hello from nested class")
        }
    }
}

class Outer {
    val msg = "Hello from outer class."
    inner class Inner {
        fun innerFun() {
            //It is possible in case of inner class
            val strMsg: String = msg
            println("Hello from inner class")
        }
    }
}

fun main() {
    println("===========Nested class demo==============")
    //Nested class object
    val o1 = Outer1.Nested()
    println(o1.nestedFun())

    //Outer class object
    val o2 = Outer1()
    println(o2.msg)

    println("===========Inner class demo===============")
    val o3 =Outer().Inner();
    println(o3.innerFun())
    println(Outer().msg)
}