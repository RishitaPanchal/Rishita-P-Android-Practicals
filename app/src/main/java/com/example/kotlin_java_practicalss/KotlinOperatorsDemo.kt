package com.example.kotlin_java_practicalss

fun main() {
    var num1 = 15
    var num2 = 7
    println("\nvalue of i --> $num1 j --> $num2 ")
    println("======Arithmatic operators=======")
    var res = num1 + num2;

    println("$num1 + $num2 = ${num1 + num2}");
    println("$num1 - $num2 = ${num1 - num2}");
    //println("$i * $j = ${i*j}");
    println("$num1 * $num2 = ${num1.times(num2)}");        //Another way to multiply two no.

    //println("$i / $j = ${i.toFloat()/j}");
    println("$num1 / $num2 = ${num1.rem(num2)}");          //Another way to divide two no.
    println("$num1 % $num2 = ${num1 % num2}");

    println("\n====Increment Decrement operator=====")
    var num =5
    //Will assign first and then increment // ans would be-->5
    println(num++)
    //Will increment first and then assign // ans would be-->7
    println(++num)

    //7 + 9 = 16
    println(num++ + ++num)

    println("\n====Relational Operator======")
    println("$num1 > $num2  = ${num1 > num2}")
    println("$num1 < $num2  = ${num1 < num2}")
    println("$num1 == $num2 = ${num1 == num2}")
    println("$num1 != $num2 = ${num1 != num2}")
    println("$num1 >= $num2 = ${num1 >= num2}")
    println("$num1 <= $num2 = ${num1 <= num2}")

    println("\n====Logical operator======")
    //Below area the status of langauges known
    var x = 20
    var y = 12
    var z = 15

    if(x > y && y < z || z > y)
        println("True")
    else
        println("false")

    println("\n=====Bitwise operator=======")
    var num3 = 12;
    var num4 = 2;
    println("$num3 shift left by $num4  = ${num3.shl(num4)}")
    println("$num3 shift right by $num4 = ${num3.shr(num4)}")
    println("36 bitwise or 22     = ${36.and(22)} ")
    println("36 bitwise and 22    = ${36.or(22)}")
    println("36 bitwise XOR 22    = ${36.xor(22)}")
}