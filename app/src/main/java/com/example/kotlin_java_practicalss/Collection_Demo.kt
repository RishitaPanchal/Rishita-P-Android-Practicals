package com.example.kotlin_java_practicalss

fun main() {
    arrayFun()
    listFun()
}
fun arrayFun() {
    val arrCoutries = arrayOf<String>("India", "Australia", "USA", "UK", "Canada")
    println("===============Array List============")
    for(index in arrCoutries.indices) {
        print(" ${arrCoutries[index]} ")
    }

    println("\n====Array List with index==========")

    //withIndex method is used to print with index
    for ((index, element) in arrCoutries.withIndex()) {
        println("arr_countries[$index] ->  $element")
    }
    println("Element at array index  0 " + arrCoutries.get(0))
    //Array is mutable so we can update the element of array
    arrCoutries.set(1, "Europe")

    println("=========Updated Array list==========")
    for (index in 0..arrCoutries.size - 1) {
        print(" " + arrCoutries[index])
    }
    println()

}

fun listFun() {
    //List provides only read only access (immutable
    var list = listOf("Round", "Ractagle", "Square", "Dimond")
    println("=============Simple list===============")
    println("List element at index 2--> ${list.get(2)}")
    println("Index of element round --> ${list.indexOf("Round")}")
    println("Is Ractangle contained in a list ?" + list.contains("Ractangle"))

    println("\n=============Mutable List=============")
    //it allows modification of list
    val mutableList:MutableList<String> = mutableListOf("Round", "Ractangle", "Square", "Diamond")
    mutableList.add("Triangle")
    println(mutableList)
}
