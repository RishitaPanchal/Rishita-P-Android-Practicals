package com.example.kotlin_java_practicalss

class Student(var enroll_no:Int, var name:String, var cource:String, var mentor:String) {
    init {
        println("Calling from init block: As primary constructor has no body")
    }
    var department = "IT dept"

    //Secondary constructor declaration
    constructor(enroll_no: Int,name: String,cource: String):
            this(enroll_no,name,cource,"ABC")

    fun dispDetails() {
        println("Enrollment number of student is\t:\t" + enroll_no)
        println("Name of the student is\t:\t" + name)
        println("Course choosen by student is\t:\t" + cource)
        println("Assigned mentor to student is\t:\t" + mentor)
    }

}
fun main() {
    val student1 = Student(15,"Rishita","Mobile development","XYZ")
    val student2 = Student(21,"Aparna","Mobile development")

    student1.dispDetails()
    println("Department \t:\t" + student1.department)
    student2.dispDetails()
}

