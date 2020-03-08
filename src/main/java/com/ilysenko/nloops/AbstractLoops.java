package com.ilysenko.nloops;

import java.util.List;

public abstract class AbstractLoops {

    Loop getLast() {
        if (getLoops().isEmpty()) {
            throw new IllegalArgumentException();
        }
        return getLoops().get(getLoops().size() - 1);
    }

    boolean isUpward(Loop loop) {
        return loop.getFrom() < loop.getTo();
    }

    protected abstract List<Loop> getLoops();
}
