package com.example.kotlin_java_practicalss;

interface SBIWithdrawal {
    void withdraw();
}

interface SBIDeposit {
    void deposit();
}

class bank implements SBIWithdrawal, SBIDeposit  {
    public void withdraw() {
        System.out.println("Maximum withdrawal amount is 20,000");
    }

    public void deposit() {
        System.out.println("Maximum card less deposit amount is 49,900");
    }

    public static void main(String[] args) {
        bank obj = new bank();
        obj.deposit();
        obj.withdraw();
    }
}