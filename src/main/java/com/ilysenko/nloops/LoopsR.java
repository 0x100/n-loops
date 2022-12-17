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

/**
 * Iterating real values
 */
public class LoopsR extends AbstractLoops {

    private List<Loop> loops;


    public LoopsR(List<Loop> loops) {
        this.loops = loops;
    }

    public LoopsR from(double value) {
        getLoops().add(new Loop().from(value));
        return this;
    }

    public LoopsR to(double value) {
        getLast().to(value);
        return this;
    }

    public LoopsR step(double value) {
        getLast().step(value);
        return this;
    }

    public void action(Action<Double> action) {
        List<Double> indices = new ArrayList<>(nCopies(getLoops().size(), 0d));
        loop(0, indices, action);
    }

    @Override
    protected List<Loop> getLoops() {
        return loops;
    }

    private void loop(int level, List<Double> indices, Action<Double> action) {
        if (level == indices.size()) {
            action.perform(indices);
            return;
        }
        Loop loop = getLoops().get(level);
        for (double i = loop.getFrom(); getCondition(i, loop); i = getIndexChange(i, loop)) {
            indices.set(level, i);
            loop(level + 1, indices, action);
        }
    }

    private boolean getCondition(double i, Loop loop) {
        return isForward(loop) ? i < loop.getTo() : i > loop.getTo();
    }

    private double getIndexChange(double i, Loop loop) {
        return isForward(loop) ? i + loop.getStep() : i - loop.getStep();
    }
}
