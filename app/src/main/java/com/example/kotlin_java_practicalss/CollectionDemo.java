package com.example.kotlin_java_practicalss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CollectionDemo {

    void alist() {
        System.out.println("=====Array List=====");

        ArrayList<String> l1 = new ArrayList<>();
        l1.add("C");
        l1.add("c++");
        l1.add("java");
        l1.add("python");
        System.out.println("List using arrayList"+l1);
        // l1.clear();

        if(l1.size()==0)
            System.out.println("empty list");
        else
            System.out.println("List has a data");
    }

    void alist2() {
        System.out.println("=====Array list1=====");
        List<Integer> l2 = Arrays.asList(88,11,99,22,77,33,66,44,55);

        Collections.sort(l2);
        System.out.println("Ascending list:"+ l2);

        Collections.reverse(l2);
        System.out.println("Descending order:"+l2);
    }

    void llist() {
        System.out.println("=====Linked List=====");

        LinkedList<Integer> ll1 = new LinkedList<>();
        ll1.add(11);
        ll1.add(22);
        ll1.add(33);
        ll1.add(44);
        Iterator<Integer> items = ll1.iterator();

        while(items.hasNext()) {
            System.out.println(items.next());
        }
    }

    void wrapClass() {
        System.out.println("=====Wrapper calss=====");
        int num1=20, num2;
        Integer data = new Integer(num1);
        System.out.println(num1); //Autoboxing means convert premetive value to wrapper class object
        num2 = data.intValue();
        System.out.println(num2); //Unboxing means converting object to premetive value

    }

    void mapp() {
        System.out.println("=====Hash map=====");

        Map<Integer,String> subjects= new HashMap<>();
        subjects.put(101,"c");
        subjects.put(102,"c++");
        subjects.put(103,"java");
        subjects.put(104,"Android");

        System.out.println("Get by specific id:"+subjects.get(103));
        System.out.println("Is Android is exist in map?"+subjects.containsValue("Android"));

        for(Map.Entry item : subjects.entrySet()) {
            System.out.println(item.getKey() + ":" + item.getValue());
        }
    }
    public static void main(String[] args)  {
        CollectionDemo c = new CollectionDemo();
        c.alist();
        c.alist2();
        c.wrapClass();
        c.llist();
        c.mapp();
    }

}

