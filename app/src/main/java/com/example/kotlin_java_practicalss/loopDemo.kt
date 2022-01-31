package com.example.kotlin_java_practicalss

import java.util.Scanner

fun main() {
    println("enter num: ")
    //to get input from user
    val sc = Scanner(System.`in`)
    var num1: Int = sc.nextInt()

    println("======1 to $num1 with default incerement=====")
    for (num in 1..num1) {
        print("$num ")
    }
    println("\n======1 to $num1 with incerement of 2========")
    //step keyword is used as increment
    for (num in 1..num1 step 2) {
        print("$num ")
    }

    println("\n==========1 to $num1 excluding $num1============")
    for(num in 1 until num1) {
        print("$num ")
    }

    println("\n=======1 to $num1 in reverse order============")
    for (num in num1 downTo 1) {
        print("$num ")
    }

    //It prints nothing
    for(num in num1..1) {
        print("$num ")
    }
    println()

    println("==============Table of $num1=====================")
    for (i in 1..5) {
        //to display vaue of variable $ symbol is used ..Its called as String templeting
        println("$num1 * $i = ${num1 * i} ")
    }

    println("=============print list using while============")
    var lang = arrayOf(1, 2, 3, 4)
    var index = 0;
    while (index < lang.size) {
        print("${lang[index]} ")
        index++
    }

    println()
}
