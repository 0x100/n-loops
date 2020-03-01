package com.ilysenko.nloops;

public class NLoopsTest {

    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
    }

    private static void test1() {
        new NLoops()
                .from(0).to(2)
                .from(1).to(3)
                .from(2).to(4)
                .action(System.out::println);
    }

    private static void test2() {
        new NLoops()
                .from(0).to(3).inc(2)
                .from(5).to(2).dec(1)
                .action(System.out::println);
    }
}
