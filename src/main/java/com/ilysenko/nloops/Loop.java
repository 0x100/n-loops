package com.ilysenko.nloops;

class Loop {
    private int from;
    private int to;
    private int step = 1;

    Loop from(int value) {
        this.from = value;
        return this;
    }

    Loop to(int value) {
        this.to = value;
        return this;
    }

    Loop step(int value) {
        this.step = value;
        return this;
    }

    int getFrom() {
        return from;
    }

    int getTo() {
        return to;
    }

    int getStep() {
        return step;
    }
}
