package com.example.kotlin_java_practicalss;

import java.util.Arrays;
import java.util.List;

public class DecisionMakingDemo {

    void ifElseEg() {
        List<String> l1= Arrays.asList("India","Australia","Paris","UK","USA");
        System.out.println("=========If else========");
        System.out.println("List is-->"+l1);

        if(l1.contains("India"))
             System.out.println("Yes! India is exist in list");
        else
            System.out.println("Nooo!");
    }

    void nestedIfEg() {
        int num1 = 10;
        System.out.println("\n=========Nested If else========");

        if(num1 == 10)
            System.out.println(num1 <  20 ? "Less than 20" : "Greater than 20");
    }

    public static void main(String args[]) {
        DecisionMakingDemo d =new DecisionMakingDemo();
        d.ifElseEg();
        d.nestedIfEg();
    }

}
