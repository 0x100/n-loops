package com.ilysenko.nloops;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NLoopsTest {

    @Test
    void testLoop1() {
        StringBuilder target = new StringBuilder();
        StringBuilder source = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 3; j++) {
                for (int k = 2; k < 4; k++) {
                    target.append(Arrays.asList(i, j, k));
                }
            }
        }

        new NLoops()
                .from(0).to(2)
                .from(1).to(3)
                .from(2).to(4)
                .action(source::append);

        assertEquals(target.toString(), source.toString());
    }

    @Test
    void testLoop2() {
        StringBuilder target = new StringBuilder();
        StringBuilder source = new StringBuilder();

        for (int i = 0; i < 3; i += 2) {
            for (int j = 5; j > 2; j--) {
                target.append(Arrays.asList(i, j));
            }
        }

        new NLoops()
                .from(0).to(3).inc(2)
                .from(5).to(2).dec(1)
                .action(source::append);

        assertEquals(target.toString(), source.toString());
    }
}
