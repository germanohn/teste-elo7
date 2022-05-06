package com.elo7.probes.service;

import com.elo7.probes.api.ObjectNotFoundException;
import com.elo7.probes.domain.Instruction;
import com.elo7.probes.domain.InstructionCommand;
import com.elo7.probes.domain.Region;
import com.elo7.probes.domain.Probe;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class to keep, retrieve, and update the list of Probe objects, and to set
 * the Region properties.
 */
public class ServiceImpl implements Service {
    private Map<Integer, Probe> probes;
    private Region region; // default is null
    private int freeId;

    public ServiceImpl() {
        probes = new TreeMap<>();
        region = null;
        freeId = 1;
    }

    /**
     * Gets the list of Probe objects, namely probes, that exist in the
     * Region so far.
     *
     * @return list of Probe objects in the Region
     */
    @Override
    public Collection<Probe> findAllProbes() {
        return probes.values();
    }

    @Override
    public Probe findProbeById(int probeId) {
        // TODO: Add exception for the case that probeId probe does not exist
        if (!probes.containsKey(probeId)) {
            throw new ObjectNotFoundException("Probe id not found - " + probeId);
        }

        return probes.get(probeId);
    }

    @Override
    public Region findRegion() {
        // TODO: Add exception for the case that the Region was not set yet
        if (this.region == null) {
            throw new ObjectNotFoundException("Region has not been set yet");
        }

        return this.region;
    }

    /**
     * Overloaded save method that just receive the probe and executed a
     * hardcoded String of instructions.
     * @param probe
     * @return
     */
    @Override
    public void save(Probe probe) {
        //  TODO: Change the default constructor of region to be a null object,
        //      and then change the save method for region to check if the object
        //      is null

        if (probe.getId() == 0) { // Post since default probeId is always 0
            // TODO: Exception for unable to land. The logic for landing should
            //  be inside probe, not here.
            probe.setId(freeId);
            probe.land(this.region);
            probes.put(freeId++, probe);
        } else { // Put
            probes.put(probe.getId(), probe);
        }
    }

    @Override
    public void save(Region region) {
        // TODO: Need to check if it won't have probes outside it; in this
        //  case, it should throw an error
        // TODO 2 (crucial): change region for rectangle
        this.region = region;
    }

    @Override
    public Probe execute(InstructionCommand instructionCommand) {
        int probeId = instructionCommand.getId();
        Probe probe = probes.get(probeId);

        //probe.move(this.region, instructionCommand.getInstructions());

        // Maybe this code should be inside Probe class by using polymorphism
        for (Instruction instruction : instructionCommand.getInstructions()) {
            probe.move(this.region, instruction);
        }

        return probe;
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
    public void deleteRegion() {
        // TODO: Add exception when region was not set yet
        this.region = null;
    }
}
