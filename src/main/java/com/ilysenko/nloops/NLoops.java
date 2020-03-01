package com.ilysenko.nloops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Optional.ofNullable;

public class NLoops {
    private List<Loop> loops = new ArrayList<Loop>();
    private Callback callback;

    public NLoops from(int from) {
        Loop loop = new Loop().from(from);
        loops.add(loop);
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

    public void action(Callback callback) {
        this.callback = callback;
        loop(0, new ArrayList<>(Collections.nCopies(loops.size(), 0)));
    }

    private void loop(int level, List<Integer> indices) {
        if (level == indices.size()) {
            callback.action(indices);
            return;
        }
        Loop loop = loops.get(level);
        for (int i = loop.getFrom(); i < loop.getTo(); i = calculateChange(loop, i)) {
            indices.set(level, i);
            loop(level + 1, indices);
        }
    }

    private Loop getLast(List<Loop> loops) {
        if (loops.isEmpty()) {
            return null;
        }
        return loops.get(loops.size() - 1);
    }

    private int calculateChange(Loop loop, int i) {
        return loop.getInc() > 0 ? i + loop.getInc() : i - loop.getDec();
    }
}
