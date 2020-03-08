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

    public LoopsD real() {
        return new LoopsD(getLoops());
    }

    public Loops from(int value) {
        getLoops().add(new Loop().from(value));
        return this;
    }

    public Loops to(int value) {
        getLast().to(value);
        return this;
    }

    public Loops step(int value) {
        getLast().step(value);
        return this;
    }

    public void action(Action<Integer> action) {
        List<Integer> indices = new ArrayList<>(nCopies(getLoops().size(), 0));
        loop(0, indices, action);
    }

    @Override
    protected List<Loop> getLoops() {
        return loops;
    }

    private void loop(int level, List<Integer> indices, Action<Integer> action) {
        if (level == indices.size()) {
            action.perform(indices);
            return;
        }
        Loop loop = getLoops().get(level);
        for (int i = (int) loop.getFrom(); getCondition(i, loop); i = getIndexChange(i, loop)) {
            indices.set(level, i);
            loop(level + 1, indices, action);
        }
    }

    private boolean getCondition(int i, Loop loop) {
        return isUpward(loop) ? i < loop.getTo() : i > loop.getTo();
    }

    private int getIndexChange(int i, Loop loop) {
        return (int) (isUpward(loop) ? i + loop.getStep() : i - loop.getStep());
    }
}
