package com.elo7.probes.service;

import com.elo7.probes.domain.Instruction;
import com.elo7.probes.domain.Plateau;
import com.elo7.probes.domain.Probe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class to keep, retrieve, and update the list of Probe objects, and to set
 * the Plateau properties.
 */
public class ServiceImpl implements Service {
    private Map<Integer, Probe> probes;
    private Plateau plateau;
    private int freeId;

    public ServiceImpl() {
        probes = new TreeMap<>();
        plateau = new Plateau();
        freeId = 1;
    }

    /**
     * Gets the list of Probe objects, namely probes, that exist in the
     * Plateau so far.
     *
     * @return list of Probe objects in the Plateau
     */
    @Override
    public List<Probe> findAllProbes() {
        return probes;
    }

    @Override
    public Probe findProbeById(int probeId) {
        // TODO: Add exception for the case that probeId probe does not exist
        return null;
    }

    @Override
    public Plateau findPlateau() {
        // TODO: Add exception for the case that the Plateau was not set yet
        return this.plateau;
    }

    /**
     * Overloaded save method that just receive the probe and executed a
     * hardcoded String of instructions.
     * @param probe
     * @return
     */
    @Override
    public void save(Probe probe) {
        String instructions = "MM";

        for (int i = 0; i < instructions.length(); i++) {
            System.out.println("Current instruction " + instructions.substring(i, i + 1));
            probe.move(this.plateau, Instruction.valueOf(
                    instructions.substring(i, i + 1)));
        }

        probes.add(probe);
    }

    @Override
    public void save(Plateau plateau) {
        // TODO: Need to check if it won't have probes outside it; in this
        // case, it should throw an error
        this.plateau = plateau;
    }

    @Override
    public void deleteProbe(int probeId) {

    }

    @Override
    public void deleteAllProbes() {

    }

    @Override
    public void deletePlateau() {

    }
}
