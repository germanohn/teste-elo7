package com.elo7.probes.domain;

public class ProbeRegister {
    private Probe probe;
    private String instructions;

    public ProbeRegister() {

    }

    public Probe getProbe() {
        return probe;
    }

    public void setProbe(Probe probe) {
        this.probe = probe;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
