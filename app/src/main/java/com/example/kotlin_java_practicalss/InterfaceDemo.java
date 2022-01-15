package com.example.kotlin_java_practicalss;

interface Salary{
    //Non abstract method is called using default keyword
    default void emp1() {
        System.out.println("Frome interface-->emp1:12000");
    }

    //Abstract methods
    void emp2();
    void emp3();
    void emp4();
}
abstract class SalaryEmp implements Salary {

    //Overriden non abstract method
    public void emp1() {
        System.out.println("Frome interface-->emp1:11000");
    }

    public void emp2() {
        System.out.println("abstract class-->emp2:30000");
    }

    public void emp3() {
        System.out.println("abstract class-->emp3:32000");
    }

    public void emp4() {
        System.out.println("abstract class-->emp4:45000");
    }
}

class Main extends SalaryEmp implements Salary {
    public static void main(String[] args) {
        Main a1 =  new Main();
        //It will call method from abstract class
        a1.emp1();
        a1.emp2();
        a1.emp3();
        a1.emp4();
    }
}
