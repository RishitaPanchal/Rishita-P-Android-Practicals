package com.example.kotlin_java_practicalss;

import java.util.Scanner;

public class ExceptionHandlingDemo {
    void exceptionsDemo() {
        //Exception handling using multiple catch block
        try {
            int array1[] = new int[5];
            String str = null;
            //Null pointer exception
            str.length();
            //Divide By zero exception
            array1[1] =15/0;
            //Array Index out of bound exception
            array1[10] = 15;

            //NumberFormat exception
            String name= "Rishita";
            int name1 = Integer.parseInt(name);
        }
        catch(NumberFormatException e) {
            System.out.println("String can not be converted into number");
        }
        catch(ArithmeticException e) {
            System.out.println("Number can not be divisible by zero");
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("exceeds the boundry of array");
        }
        catch(NullPointerException e) {
            System.out.println("Null pointer exception raised!!");
        }
        finally {
            System.out.println("FInally excecuted");
        }
    }

    void throwEg() {
        System.out.println("\n======Throw demo(To create a custom exception)======");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number:");
        int num = sc.nextInt();

        if(num < 0) {
            throw new ArithmeticException("Number should not be negative");
        } else {
            System.out.println("Number is positive");
        }
    }

    public static void main(String[] args) {
        ExceptionHandlingDemo e = new ExceptionHandlingDemo();
        e.exceptionsDemo();
        e.throwEg();
    }
}
