package com.demo.java;

public class StringDemo {
    public static void main(String arr[]){
        String name="Hem Chandra";
        boolean b=name.chars().anyMatch(x ->Character.isUpperCase(x));
        System.out.println(b);
    }
}
