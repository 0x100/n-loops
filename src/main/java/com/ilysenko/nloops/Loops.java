/*
 * MIT License
 *
 * Copyright (c) 2020 Ilya Lysenko
 *
 * A short and simple permissive license with conditions only requiring preservation of copyright and license notices.
 * Licensed works, modifications, and larger works may be distributed under different terms and without source code.
 */
package com.ilysenko.nloops;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.nCopies;

public class Loops extends AbstractLoops {
    private List<Loop> loops = new ArrayList<>();

    public Loops() {
    }

    public Loops(List<Loop> loops) {
        this.loops = loops;
    }

    public LoopsR real() {
        return new LoopsR(getLoops());
    }

    public Loops from(int value) {
        getLoops().add(new Loop().from(value));
        return this;
    }

    public Loops fromAbove(int value) {
        if (getLoops().size() == 0) {
            throw new RuntimeException("No one loop above!");
        }
        getLoops().add(new Loop().fromAbove(value));
        return this;
    }

    public Loops to(int value) {
        getLast().to(value);
        return this;
    }

    public Loops toAbove(int value) {
        if (getLoops().size() == 0) {
            throw new RuntimeException("No one loop above!");
        }
        getLast().toAbove(value);
        return this;
    }

    public Loops step(int value) {
        getLast().step(value);
        return this;
    }

    public void action(Action<Integer> action) {
        List<Integer> indices = new ArrayList<>(nCopies(getLoops().size(), 0));
        iterate(0, indices, action);
    }

    @Override
    protected List<Loop> getLoops() {
        return loops;
    }

    private void iterate(int level, List<Integer> indices, Action<Integer> action) {
        if (level == indices.size()) {
            action.perform(indices);
            return;
        }
        Loop loop = getLoops().get(level);
        boolean isFromAbove = loop.isFromAbove();
        int valueAbove = isFromAbove ? indices.get(level - 1) : 0;
        int fromValue = (int) loop.getFrom();
        int from = isFromAbove ? valueAbove + fromValue : fromValue;

        for (int i = from; getCondition(i, loop, valueAbove); i = getIndexChange(i, loop)) {
            indices.set(level, i);
            iterate(level + 1, indices, action);
        }
    }

    private boolean getCondition(int i, Loop loop, int valueAbove) {
        double to = loop.isToAbove() ? valueAbove + loop.getTo() : loop.getTo();
        return isForward(loop) ? i < to : i > to;
    }

    private int getIndexChange(int i, Loop loop) {
        return (int) (isForward(loop) ? i + loop.getStep() : i - loop.getStep());
    }
}
