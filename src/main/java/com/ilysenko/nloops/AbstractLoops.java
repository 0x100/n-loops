/*
 * MIT License
 *
 * Copyright (c) 2020 Ilya Lysenko
 *
 * A short and simple permissive license with conditions only requiring preservation of copyright and license notices.
 * Licensed works, modifications, and larger works may be distributed under different terms and without source code.
 */
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
