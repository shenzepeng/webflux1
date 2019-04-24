package com.example.webflux1.utils;

public class Test {
    public static void main(String[] args) {
        String string="123456";
        EncryptUtil encryptUtil =EncryptUtil.getInstance();
        String s = encryptUtil.MD5(string);
        System.out.println(s);
    }
}
