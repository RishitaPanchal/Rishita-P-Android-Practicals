package com.example.kotlin_java_practicalss

fun main() {
    //var name:String = null  : Kotlin doesnot allow you to specify value as a null
    ///By applying ? after any dtatatype it will allow you to assign null value
    var name: String? = null
    println(name?.length)

    // Example of safe call: It executes the block only if name is not null otherwise it print nothing
    name?.let {
        println("Length of name :${name.length}")
    } ?: print("nil\n")

    //Example of elvis operator
    var len = name?.length ?: -1
    println("Lenght of name : $len")

    //Non null assertion (!!) give you an error if name has null value
    var name1: String? = "Rishita"
    println("Length of name is : ${name1!!.length}")
}