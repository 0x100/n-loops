package com.ilysenko.nloops;

import java.util.List;

@FunctionalInterface
public interface Action {
    void perform(List<Integer> indices);
}