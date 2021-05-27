package com.test.demo;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName GcDemo
 * @Author chenjian
 * @Date 2021-05-20 16:23
 */
public class GcDemo {
    public static void main(String[] args) {
        try {
            test3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void test1() {
        byte[] bytes1 = new byte[1024 * 1024];//1m
        bytes1 = new byte[1024 * 1024];//1m
        bytes1 = new byte[1024 * 1024];//1m
        byte[] bytes0 = new byte[1024 * 1024];//128kb
        //直接分配一个5m的对象，由于eden区只有8m，之前已经分配了3m再加上一些未知对象也会占据一定的内存空间，此时必然会引起新生代gc
        byte[] bytes3 = new byte[5 * 1024 * 1024];//5m
    }

    public static void test2() {
        byte[] bytes1 = new byte[1024 * 1024];//1m
        bytes1 = new byte[1024 * 1024];//1m
        bytes1 = new byte[1024 * 1024];//1m
        //直接分配一个5m的对象，由于eden区只有8m，之前已经分配了3m再加上一些未知对象也会占据一定的内存空间，此时必然会引起新生代gc
        byte[] bytes3 = new byte[5 * 1024 * 1024];//5m
    }

    public static void test3() throws InterruptedException {
        Thread.sleep(10000);
        byte[] bytes1 = new byte[1024 * 1024];
        for (;;){
            bytes1 = new byte[1024];
            Thread.sleep(100);
        }
    }
}
