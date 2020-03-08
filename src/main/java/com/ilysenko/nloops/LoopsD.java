package com.ilysenko.nloops;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.nCopies;

/**
 * Iterating real values
 */
public class LoopsD extends AbstractLoops {
    private List<Loop> loops;

    public LoopsD(List<Loop> loops) {
        this.loops = loops;
    }

    public LoopsD from(double value) {
        getLoops().add(new Loop().from(value));
        return this;
    }

    public LoopsD to(double value) {
        getLast().to(value);
        return this;
    }

    public LoopsD step(double value) {
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
        return isUpward(loop) ? i < loop.getTo() : i > loop.getTo();
    }

    private double getIndexChange(double i, Loop loop) {
        return isUpward(loop) ? i + loop.getStep() : i - loop.getStep();
    }
}
