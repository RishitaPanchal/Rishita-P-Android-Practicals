package com.example.kotlin_java_practicalss;

public class EnumerationDemo {
    enum letters {
        A, E, I, O, U
    }

    public static void main(String[] args) {
        for (letters vowel : letters.values()) {
            System.out.println(vowel);
        }

        System.out.println("Value of letter A:"+letters.valueOf("A"));
        System.out.println("Index of letter E:"+letters.valueOf("E").ordinal());
        System.out.println("Index of letter U:"+letters.valueOf("U").ordinal());
        System.out.println("\n============Switch case using enumeration==============");

        letters vowel = letters.A;

        switch (vowel) {
            case A:
                System.out.println("Choosen letter is A");
                break;
            case E:
                System.out.println("Choosen letter is E");
            case I:
                System.out.println("Choosen letter is I");
                break;
            case O:
                System.out.println("Choosen letter is O");
                break;
            case U:
                System.out.println("Choose letter is U");
                break;

                // We can omit default if all the enum cases are included iin switch
        }
    }
}
