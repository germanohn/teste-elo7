package com.elo7.probes.domain;

public class InstructionCommand {
    private int id;
    private Instruction[] instructions;

    public InstructionCommand() {
    }

    public InstructionCommand(int id, Instruction[] instructions) {
        this.id = id;
        this.instructions = instructions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instruction[] getInstructions() {
        return instructions;
    }

    public void setInstructions(Instruction[] instructions) {
        this.instructions = instructions;
    }
}
