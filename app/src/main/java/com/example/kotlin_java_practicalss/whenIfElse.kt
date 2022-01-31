package com.example.kotlin_java_practicalss

fun main() {
    val str = "Java"
    println("By using if-else-if");

    if(str == "C++") {
        println("Choosen langauge is c++");
    } else if(str == "Java") {
        println("Choosen language is java");
    } else if (str == "kotlin") {
        println("Choosen language is kotlin");
    } else {
        println("Language is out of the list");
    }

    println("========Switch case(using when)=======")
    //it is act as switch case
    when(str) {
        "c++" -> println("choosen language is c++")
        "c"-> println("choosen language is c")
        "Java" -> println("choosen language is java")
        //It act as default keyword
        else -> println("Language is out of the list")
    }

    println("=========Switch case (cases are in the range)=======")
    var age: Int = 22
    when(age) {
           -1 ,-2 -> println("AGe can not be negative")
           in 0..12-> println("Age lies in child group ")
           in 13..19-> println("Age lies in teenage group")
           in 20..40-> println("Age lies in Youth group")
           in 41..100-> println("Age lies in senior citizen group")
           else -> println("Age beyond 100 years")
    }
}