package com.example.kotlin_java_practicalss;

abstract class Jaguar {
    //Constructor
    Jaguar() { 
        System.out.println("Jaguar cunstructor called"); 
    }
    //Abstract method
    abstract void speed();

    //Non abstract method
    void color() {
        System.out.println("Color: Red");
    }
    void model() {
        System.out.println("model: XF");
    }
}

class Car extends Jaguar {
    void speed() {
        System.out.println("Speed : 250kmph"); // Abstract method implemented in this class
    }

    public static void main(String[] args) {
       // Object can not be created of abstract class
        Jaguar j = new Car();
        j.speed();
        j.color();
        j.model();
    }
}
