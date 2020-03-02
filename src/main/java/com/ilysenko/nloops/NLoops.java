package com.ilysenko.nloops;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.nCopies;

public class NLoops {
    private List<Loop> loops = new ArrayList<>();

    public NLoops from(int from) {
        loops.add(new Loop().from(from));
        return this;
    }

    public NLoops to(int to) {
        getLast(loops).to(to);
        return this;
    }

    public NLoops inc(int inc) {
        getLast(loops).inc(inc);
        return this;
    }

    public NLoops dec(int dec) {
        getLast(loops).dec(dec);
        return this;
    }

    public void action(Action action) {
        List<Integer> indices = new ArrayList<>(nCopies(loops.size(), 0));
        loop(0, indices, action);
    }

    private void loop(int level, List<Integer> indices, Action action) {
        if (level == indices.size()) {
            action.perform(indices);
            return;
        }
        Loop loop = loops.get(level);
        for (int i = loop.getFrom(); getCondition(i, loop); i = getIndexChange(i, loop)) {
            indices.set(level, i);
            loop(level + 1, indices, action);
        }
    }

    private Loop getLast(List<Loop> loops) {
        if (loops.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return loops.get(loops.size() - 1);
    }

    private boolean getCondition(int i, Loop loop) {
        return isUpward(loop) ? i < loop.getTo() : i > loop.getTo();
    }

    private int getIndexChange(int i, Loop loop) {
        return isUpward(loop) ? i + loop.getInc() : i - loop.getDec();
    }

    private boolean isUpward(Loop loop) {
        return loop.getFrom() < loop.getTo();
    }
}
