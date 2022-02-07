package com.example.kotlin_java_practicalss

class Chaining {

    companion object {
        var i = 0
    }

    fun chain(): Chaining {
        Chaining.i += 1
        return this
    }
}

fun main() {
    val c = Chaining()
    c.
    chain()
        .chain()
        .chain()
}