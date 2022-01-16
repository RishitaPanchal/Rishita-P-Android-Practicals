package com.example.kotlin_java_practicalss

//by default class is final & public so, we have to make class open
open class Car {
    var color: String = ""
    fun type() {
        println("Color of car is: $color")
        println("Type of car is: sadan")
    }
}

class Jeguar: Car() {
   fun speed() {
       println("Jeguar speed: 200kmhr")
   }
}

class Bmw: Car() {
    fun engine() {
        println("ENgine type: Petrol car")
    }
}

fun main() {
    val jeguar = Jeguar()
    println("======Car jeguar specification=====")
    jeguar.color ="black"
    jeguar.type()
    jeguar.speed()

    val bmw = Bmw()
    println("======Car BMW specification=====")
    bmw.color ="White"
    bmw.type()
    bmw.engine()
}