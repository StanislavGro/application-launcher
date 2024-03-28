package com.launcher.api;

public class Main {
    public static void main(String[] args) {
        String s1 = "1";
        String s2 = new String("1");

        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);

        A a1 = new A();
        A a2 = new A();

        System.out.println(a1.equals(a2));
        System.out.println(a1 == a2);
    }
}

