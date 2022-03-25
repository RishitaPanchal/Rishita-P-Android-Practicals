package architecture.bindingadapters

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val job1 = launch {
            delay(3000L)
            println("Job1 launched")
        }
        job1.invokeOnCompletion { println("Job1 completed") }
        delay(500L)
        println("Job1 will be canceled")
        job1.cancel()
    }
}