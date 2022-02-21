package com.example.kotlin_java_practicalss

sealed class SealedClassDemo {

    class class1(val name: String): SealedClassDemo() {

        fun displayDataClass1() {
            println(name)
        }

    }
    class class2(val surname: String): SealedClassDemo() {

        fun displayDataClass2() {
            println(surname)
        }

    }

}

sealed class Flower(val color: String) {

    class Rose: Flower("red")
    class Lily: Flower("Blue")

}

fun display(flower: Flower) {
    when(flower) {
        is Flower.Rose -> println("\nColor : ${flower.color}")
        is Flower.Lily -> println("\nColor : ${flower.color}")
    }
}
fun main() {
    val obj1 = SealedClassDemo.class1("Rishita")
    obj1.displayDataClass1()

    val obj2 = SealedClassDemo.class2("Panchhal")
    obj2.displayDataClass2()

    val fObj1 = Flower.Rose()
    display(fObj1)
}
