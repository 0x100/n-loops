package com.ilysenko.nloops;

import java.util.List;

@FunctionalInterface
public interface Action<T extends Number> {
    void perform(List<T> indices);
}