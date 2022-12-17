/*
 * MIT License
 *
 * Copyright (c) 2020 Ilya Lysenko
 *
 * A short and simple permissive license with conditions only requiring preservation of copyright and license notices.
 * Licensed works, modifications, and larger works may be distributed under different terms and without source code.
 */
package com.ilysenko.nloops;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.ilysenko.nloops.Loop.loop;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoopsTest {

    @Test
    void test1() {
        StringBuilder target = new StringBuilder();
        StringBuilder source = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 3; j++) {
                for (int k = 2; k < 4; k++) {
                    target.append(Arrays.asList(i, j, k));
                }
            }
        }

        new Loops()
                .from(0).to(2)
                .from(1).to(3)
                .from(2).to(4)
                .action(source::append);

        assertEquals(target.toString(), source.toString());
    }

    @Test
    void test2() {
        StringBuilder target = new StringBuilder();
        StringBuilder source = new StringBuilder();

        for (int i = 0; i < 3; i += 2) {
            for (int j = 7; j > 2; j--) {
                for (int k = 18; k > 5; k -= 3) {
                    for (int l = 1; l < 4; l++) {
                        target.append(Arrays.asList(i, j, k, l));
                    }
                }
            }
        }

        new Loops()
                .from(0).to(3).step(2)
                .from(7).to(2)
                .from(18).to(5).step(3)
                .from(1).to(4)
                .action(source::append);

        assertEquals(target.toString(), source.toString());
    }

    @Test
    void test3() {
        StringBuilder target = new StringBuilder();
        StringBuilder source = new StringBuilder();

        for (int i = 0; i < 3; i += 2) {
            for (int j = 7; j > 2; j--) {
                for (int k = 18; k > 5; k -= 3) {
                    for (int l = 1; l < 4; l++) {
                        target.append(Arrays.asList(i, j, k, l));
                    }
                }
            }
        }

        List<Loop> loops = Arrays.asList(
                new Loop(0, 3, 2),
                new Loop(7, 2),
                new Loop(18, 5, 3),
                new Loop(1, 4));

        new Loops(loops)
                .action(source::append);

        assertEquals(target.toString(), source.toString());
    }

    @Test
    void test4() {
        StringBuilder target = new StringBuilder();
        StringBuilder source = new StringBuilder();

        for (int i = 0; i < 3; i += 2) {
            for (int j = 7; j > 2; j--) {
                for (int k = 18; k > 5; k -= 3) {
                    for (int l = 1; l < 4; l++) {
                        target.append(Arrays.asList(i, j, k, l));
                    }
                }
            }
        }

        List<Loop> loops = Arrays.asList(
                loop().from(0).to(3).step(2),
                loop().from(7).to(2),
                loop().from(18).to(5).step(3),
                loop().from(1).to(4));

        new Loops(loops)
                .action(source::append);

        assertEquals(target.toString(), source.toString());
    }

    @Test
    void test5() {
        StringBuilder target = new StringBuilder();
        StringBuilder source = new StringBuilder();

        for (int i = 0; i < 3; i += 2) {
            for (int j = 7; j > 2; j--) {
                for (int k = 18; k > 5; k -= 3) {
                    for (int l = 1; l < 4; l++) {
                        target.append(Arrays.asList(i, j, k, l));
                    }
                }
            }
        }

        List<Loop> loops = Arrays.asList(
                loop(0, 3).step(2),
                loop(7, 2),
                loop(18, 5, 3),
                loop().from(1).to(4));

        new Loops(loops)
                .action(source::append);

        assertEquals(target.toString(), source.toString());
    }

    @Test
    public void test6() {
        StringBuilder target = new StringBuilder();
        StringBuilder source = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            for (int j = i; j < 3; j++) {
                for (int k = j + 1; k < 4; k++) {
                    for (int l = 1; l < k + 2; l++) {
                        target.append(Arrays.asList(i, j, k, l));
                    }
                }
            }
        }

        List<Loop> loops = Arrays.asList(
                new Loop().from(0).to(2),
                new Loop().fromAbove(0).to(3),
                new Loop().fromAbove(+ 1).to(4),
                new Loop().from(1).toAbove(+ 2));

        new Loops(loops)
                .action(source::append);

        assertEquals(target.toString(), source.toString());
    }
}
