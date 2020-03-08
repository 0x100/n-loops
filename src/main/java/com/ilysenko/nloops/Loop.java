package com.ilysenko.nloops;

public class Loop {
    private double from;
    private double to;
    private double step = 1;

    public Loop() {
    }

    public Loop(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public Loop(double from, double to, double step) {
        this.from = from;
        this.to = to;
        this.step = step;
    }

    public static Loop loop() {
        return new Loop();
    }

    public static Loop loop(double from, double to) {
        return new Loop(from, to);
    }

    public static Loop loop(double from, double to, double step) {
        return new Loop(from, to, step);
    }

    public Loop from(double value) {
        this.from = value;
        return this;
    }

    public Loop to(double value) {
        this.to = value;
        return this;
    }

    public Loop step(double value) {
        this.step = value;
        return this;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public double getStep() {
        return step;
    }
}
