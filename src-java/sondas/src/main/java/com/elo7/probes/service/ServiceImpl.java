package com.elo7.probes.service;

import com.elo7.probes.domain.Instruction;
import com.elo7.probes.domain.Probe;
import com.elo7.probes.domain.Region;
import com.elo7.probes.dto.ProbeDto;
import com.elo7.probes.dto.RegionDto;
import com.elo7.probes.exception.EntityNotFoundException;
import com.elo7.probes.form.ProbeForm;
import com.elo7.probes.form.RegionForm;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
     * @return list of Probe objects, possibly empty, in the Region.
     */
    @Override
    public List<ProbeDto> findAllProbes() {
        return probes.values().stream().map(probe -> new ProbeDto(probe)).collect(Collectors.toList());
    }

    @Override
    public ProbeDto findProbeById(int probeId) {
        if (!probes.containsKey(probeId)) {
            throw new EntityNotFoundException("Probe with id " + probeId + " not found");
        }

        return new ProbeDto(probes.get(probeId));
    }

    @Override
    public RegionDto findRegion() {
        if (this.region == null) {
            throw new EntityNotFoundException("Region not set");
        }

        return new RegionDto(this.region);
    }

    /**
     * Overloaded save method that just receive the probe and executed a
     * hardcoded String of instructions.
     * @param probeForm
     * @return
     */
    @Override
    public ProbeDto save(ProbeForm probeForm) { // probe.getId() is always 0, because it is landing
        Probe probe = probeForm.convertToProbe();
        probe.land(this.region);
        probe.setId(freeId);
        probes.put(freeId++, probe);
        return new ProbeDto(probe);
    }

    @Override
    public RegionDto save(RegionForm regionForm) {
        // TODO: Need to check if it won't have probes outside it; in this
        //  case, it should throw an error
        this.region = regionForm.convertToRegion();
        return new RegionDto(this.region);
    }

    @Override
    public ProbeDto execute(int probeId, Instruction[] instructions) {
        Probe probe = probes.get(probeId);

        probe.move(this.region, instructions);

        return new ProbeDto(probe);
    }

    @Override
    public void deleteProbe(int probeId) {
        if (!probes.containsKey(probeId)) {
            throw new EntityNotFoundException("Probe with id " + probeId + " not found");
        }
        this.region.freePosition(probes.get(probeId).getOrientedPosition().getPosition());
        this.probes.remove(probeId);
    }

    @Override
    public void deleteAllProbes() {
        // TODO: It has to update the maximum coordinates of probes seen in
        //  the current region so far
        this.region.freeAllPositions();
        this.probes.clear();
    }

    @Override
    public void deleteRegion() {
        this.region = null;
    }
}
