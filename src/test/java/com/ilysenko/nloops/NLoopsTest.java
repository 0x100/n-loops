package com.ilysenko.nloops;

public class NLoopsTest {

    public static void main(String[] args) {
        new NLoops()
                .from(0).to(2)
                .from(1).to(3)
                .from(2).to(4)
                .action(System.out::println);
        System.out.println();
    }
}
