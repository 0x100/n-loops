package com.ilysenko.nloops;

public class Loop {
    private int from;
    private int to;
    private int inc = 1;
    private int dec;

    public Loop from(int from) {
        this.from = from;
        return this;
    }

    public Loop to(int to) {
        this.to = to;
        return this;
    }

    public Loop inc(int inc) {
        this.inc = inc;
        return this;
    }

    public Loop dec(int dec) {
        this.dec = dec;
        return this;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getInc() {
        return inc;
    }

    public int getDec() {
        return dec;
    }
}
