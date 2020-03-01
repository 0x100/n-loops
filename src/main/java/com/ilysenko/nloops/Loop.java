package com.ilysenko.nloops;

class Loop {
    private int from;
    private int to;
    private int inc = 1;
    private int dec;

    Loop from(int from) {
        this.from = from;
        return this;
    }

    Loop to(int to) {
        this.to = to;
        return this;
    }

    Loop inc(int inc) {
        this.inc = inc;
        return this;
    }

    Loop dec(int dec) {
        this.dec = dec;
        return this;
    }

    int getFrom() {
        return from;
    }

    int getTo() {
        return to;
    }

    int getInc() {
        return inc;
    }

    int getDec() {
        return dec;
    }
}
