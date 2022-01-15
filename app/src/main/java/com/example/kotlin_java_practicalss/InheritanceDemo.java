package com.example.kotlin_java_practicalss;

//==============Example of multilevel inheritance & method overriding======================
class Mobile {
    public void storage() {
        System.out.println("Storage of mobile is 128 gb");
    }
}
class Android extends Mobile {
    public void storage() {
        System.out.println("Storage of android 64 gb");
    }
}
class Samsung extends Android {
    public void storage() {
        System.out.println("Storage of samsung 32 gb");
    }

    public static void main(String[] args) {
        Mobile mobile = new Mobile();

        //Below are the upcasting to call a overrided method
        Mobile android = new Android();
        Mobile samsung  = new Samsung();

        mobile.storage();                //It will call the method of samsung class
        android.storage();               //It will call the method of android class
        samsung.storage();               //It will call the method of samsung class
    }
}
