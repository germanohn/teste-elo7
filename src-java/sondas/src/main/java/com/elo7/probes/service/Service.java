package com.elo7.probes.service;

import com.elo7.probes.domain.Plateau;
import com.elo7.probes.domain.Probe;

import java.util.List;

public interface Service {

    public List<Probe> findAllProbes();

    public Probe findProbeById(int probeId);

    public Plateau findPlateau();

    public void save(Probe probe);

    public void save(Plateau plateau);

    public void deleteProbe(int probeId);

    public void deleteAllProbes();

    public void deletePlateau();
}
