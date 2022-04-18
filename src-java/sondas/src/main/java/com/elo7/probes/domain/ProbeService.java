package com.elo7.probes.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to keep, retrieve, and update the list of Probe objects, and to set
 * the plateau properties.
 */
public class ProbeService {
    private List<Probe> probes = new ArrayList<>();
    private Plateau plateau = new Plateau();

    /**
     * Gets the list of Probe objects, namely probes, that exist in the
     * Plateau so far.
     *
     * @return list of Probe objects in the Plateau
     */
    public List<Probe> getProbes() {
        return probes;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    /**
     * Overloaded save method that just receive the probe and executed a
     * hardcoded String of instructions.
     * @param probe
     * @return
     */
    public Probe save(Probe probe) {
        String instructions = "MM";

        for (int i = 0; i < instructions.length(); i++) {
            System.out.println("Current instruction " + instructions.substring(i, i + 1));
            probe.move(plateau, Instruction.valueOf(
                    instructions.substring(i, i + 1)));
        }

        probes.add(probe);

        return probe;
    }

    /**
     * Perform instructions on a Probe object, and then add it with its new
     * position and cardinal direction in the list probes
     *
     * @param probe        the Probe object to receive instructions and be
     *                     added to the probes list
     * @param instructions String of instructions for the Probe object probe
     * @return             the Probe object added to the probes list
     */
    public Probe save(Probe probe, String instructions) {

        // if instructions is a String
        for (int i = 0; i < instructions.length(); i++) {
            probe.move(plateau, Instruction.valueOf(
                    instructions.substring(i, i + 1)));
        }

        // if instructions is an array of Instruction elements
        /*
        for (Instruction instruction : instructions) {
            probe.move(this.plateau, instruction);
        }
        */
        probes.add(probe);

        return probe;
    }
}
