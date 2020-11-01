package com.youzhong.test;

public class Test {
    public static void main(String[] args) {
        int k = 0;
        int ret = ++k + k++ + ++k + k;

        System.out.println(ret);
    }

}
