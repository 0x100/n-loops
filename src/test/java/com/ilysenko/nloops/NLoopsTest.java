package com.ilysenko.nloops;

import java.util.Arrays;

public class NLoopsTest {

    public static void main(String[] args) {
        new NLoops()
                .from(0).to(2)
                .from(1).to(3)
                .from(2).to(4)
                .action(System.out::println);
        System.out.println();

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 3; j++) {
                for (int k = 2; k < 4; k++) {
                    System.out.println(Arrays.asList(i, j, k));
                }
            }
        }
    }
}
