package com.elo7.probes.service;

import com.elo7.probes.domain.InstructionCommand;
import com.elo7.probes.domain.Plateau;
import com.elo7.probes.domain.Probe;

import java.util.Collection;

public interface Service {

    public Collection<Probe> findAllProbes();

    public Probe findProbeById(int probeId);

    public Plateau findPlateau();

    public void save(Probe probe);

    public void save(Plateau plateau);

    public Probe execute(InstructionCommand instructionCommand);

    public void deleteProbe(int probeId);

    public void deleteAllProbes();

    public void deletePlateau();
}
