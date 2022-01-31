package com.example.kotlin_java_practicalss

fun main() {
    calculator(10,5,"*")
    println("mod value-->" + mod(5,2))
    greaterOrNot(5,2)
    counter()
    varArgFunc(1, 2, 3, 4, 5)
}

//Unit can be ommited it's optional when function returns nothing
fun calculator(n1: Int, n2: Int, ch: String):Unit {
    println("You have choosen-->' $ch '")
    when(ch) {
        "+" -> println("$n1 + $n2 = ${n1+n2}")
        "-" -> println("$n1 - $n2 = ${n1-n2}")
        "*" -> println("$n1 * $n2 = ${n1*n2}")
        "/" -> println("$n1 / $n2 = ${n1+n2}")
        else -> println("Choice invalid")
    }
}

//Inline function
fun mod(n1: Int, n2: Int): Int = n1 % n2

fun greaterOrNot(n1: Int, n2: Int) {
    //conditional or ternary operator
    var res = if(n1 > n2) println("$n1 is Greater than $n2") else println("$n1 is smaller than $n2")
    println(res)
}

//Function with default argument
fun counter(cnt: Int = 2) {
    println("Counter values-->")
    for(i in 1..cnt) {
        println(i)
    }
}
//Function with multiple arguments
fun varArgFunc(vararg num: Int) {
    for(i in 1..num.count()) {
        print("$i ")
    }
}
