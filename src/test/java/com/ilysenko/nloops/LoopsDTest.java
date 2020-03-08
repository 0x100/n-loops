package com.ilysenko.nloops;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoopsDTest {

    @Test
    void testLoopsD1() {
        StringBuilder target = new StringBuilder();
        StringBuilder source = new StringBuilder();

        for (double i = 0; i < 2.5; i ++) {
            for (double j = 1.5; j < 3.99; j += 0.5) {
                for (double k = 2.5; k < 4.5; k += 0.1) {
                    target.append(Arrays.asList(i, j, k));
                }
            }
        }

        new Loops().real()
                .from(0).to(2.5)
                .from(1.5).to(3.99).step(0.5)
                .from(2.5).to(4.5).step(0.1)
                .action(source::append);

        assertEquals(target.toString(), source.toString());
    }

    @Test
    void testLoopsD2() {
        StringBuilder target = new StringBuilder();
        StringBuilder source = new StringBuilder();

        for (double i = 0.1; i < 3; i += 1.5) {
            for (double j = 7; j > 2.5; j--) {
                for (double k = 18; k > 5.99; k -= 0.5) {
                    for (double l = 1.5; l < 5; l++) {
                        target.append(Arrays.asList(i, j, k, l));
                    }
                }
            }
        }

        new Loops().real()
                .from(0.1).to(3).step(1.5)
                .from(7).to(2.5)
                .from(18).to(5.99).step(0.5)
                .from(1.5).to(5)
                .action(source::append);

        assertEquals(target.toString(), source.toString());
    }

    @Test
    void testLoopsD3() {
        StringBuilder target = new StringBuilder();
        StringBuilder source = new StringBuilder();

        for (double i = 0; i < 3.5; i += 0.5) {
            for (double j = 7; j > 2.5; j--) {
                for (double k = 18; k > 5.5; k -= 5.5) {
                    for (double l = 1.5; l < 4; l++) {
                        target.append(Arrays.asList(i, j, k, l));
                    }
                }
            }
        }

        List<Loop> loops = Arrays.asList(
                new Loop(0, 3.5, 0.5),
                new Loop(7, 2.5),
                new Loop(18, 5.5, 5.5),
                new Loop(1.5, 4));

        new Loops(loops).real()
                .action(source::append);

        assertEquals(target.toString(), source.toString());
    }

    @Test
    void testLoopsD4() {
        StringBuilder target = new StringBuilder();
        StringBuilder source = new StringBuilder();

        for (double i = 0; i < 3.5; i += 0.5) {
            for (double j = 7; j > 2.5; j--) {
                for (double k = 18; k > 5.5; k -= 3.5) {
                    for (double l = 0.99; l < 4.99; l++) {
                        target.append(Arrays.asList(i, j, k, l));
                    }
                }
            }
        }

        List<Loop> loops = Arrays.asList(
                new Loop().from(0).to(3.5).step(0.5),
                new Loop().from(7).to(2.5),
                new Loop().from(18).to(5.5).step(3.5),
                new Loop().from(0.99).to(4.99));

        new Loops(loops).real()
                .action(source::append);

        assertEquals(target.toString(), source.toString());
    }
}
