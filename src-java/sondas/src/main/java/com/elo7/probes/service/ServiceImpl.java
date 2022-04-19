package com.elo7.probes.service;

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
    private Plateau plateau; // default is null
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
        return new ArrayList<>(probes.values());
    }

    @Override
    public Probe findProbeById(int probeId) {
        // TODO: Add exception for the case that probeId probe does not exist
        return probes.get(probeId);
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
        // TODO: Add exception for being unable to land since the space is not
        //  free, or it is outside of current Plateau, or Plateau is not set yet
        //  TODO: Change the default constructor of plateau to be a null object,
        //      and then change the save method for plateau to check if the object
        //      is null
        /*
        String instructions = "MM";

        for (int i = 0; i < instructions.length(); i++) {
            System.out.println("Current instruction " + instructions.substring(i, i + 1));
            probe.move(this.plateau, Instruction.valueOf(
                    instructions.substring(i, i + 1)));
        }*/

        if (probe.getId() == 0) { // Post since default probeId is always 0
            probe.setId(freeId);
            probes.put(freeId++, probe);
        } else { // Put
            probes.put(probe.getId(), probe);
        }
    }

    @Override
    public void save(Plateau plateau) {
        // TODO: Need to check if it won't have probes outside it; in this
        //  case, it should throw an error
        this.plateau = plateau;
    }

    @Override
    public void deleteProbe(int probeId) {
        // TODO: Add exception for non-existence of probe with probeId in
        //  probes
        probes.remove(probeId);
    }

    @Override
    public void deleteAllProbes() {
        // TODO: Add exception for empty probes
        // TODO: It has to update the maximum coordinates of probes seen in
        //  the current so far
        probes.clear();
    }

    @Override
    public void deletePlateau() {
        // TODO: Add exception when plateau was not set yet
        plateau = null;
    }
}
