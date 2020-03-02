package com.ilysenko.nloops;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.nCopies;
import static java.util.Optional.ofNullable;

public class NLoops {
    private List<Loop> loops = new ArrayList<>();

    public NLoops from(int from) {
        loops.add(new Loop().from(from));
        return this;
    }

    public NLoops to(int to) {
        ofNullable(getLast(loops)).orElseThrow(IllegalArgumentException::new).to(to);
        return this;
    }

    public NLoops inc(int inc) {
        ofNullable(getLast(loops)).orElseThrow(IllegalArgumentException::new).inc(inc);
        return this;
    }

    public NLoops dec(int dec) {
        ofNullable(getLast(loops)).orElseThrow(IllegalArgumentException::new).dec(dec);
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

    private boolean getCondition(int i, Loop loop) {
        return loop.getFrom() < loop.getTo() ? i < loop.getTo() : i > loop.getTo();
    }

    private Loop getLast(List<Loop> loops) {
        if (loops.isEmpty()) {
            return null;
        }
        return loops.get(loops.size() - 1);
    }

    private int getIndexChange(int i, Loop loop) {
        return loop.getFrom() < loop.getTo() ? i + loop.getInc() : i - loop.getDec();
    }
}
