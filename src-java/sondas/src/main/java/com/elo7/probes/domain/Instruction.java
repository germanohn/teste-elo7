package com.elo7.probes.domain;

public enum Instruction {
    L(-1),
    M(0),
    R(1);

    private final int value;

    Instruction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
