package com.example.kotlin_java_practicalss

import java.util.Scanner

fun main() {
    var num1 = 5
    println(num1)
    //Var can be changed
    num1 = 10
    //i = 2.11 : Error because we cant assign float to integer type of variable
    println(num1)

    //Variable num with explicitly defined datatype
    var num: Int = 5;
    println(num);

    val num2 = 10;
    println(num2);
    // num2 = 20 : It will give you an error bcz val is act like constant

    print("enter n1:")
    //To get input string only from user
    val name = readLine()!!

    println("enter num: ")
    val sc = Scanner(System.`in`)                               //to get input of any typefrom user
    var number1:Int = sc.nextInt()

}