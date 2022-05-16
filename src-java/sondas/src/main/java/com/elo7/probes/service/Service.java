package com.elo7.probes.service;

import com.elo7.probes.domain.Instruction;
import com.elo7.probes.dto.ProbeDto;
import com.elo7.probes.dto.RegionDto;
import com.elo7.probes.form.ProbeForm;
import com.elo7.probes.form.RegionForm;

import java.util.List;

public interface Service {

    public List<ProbeDto> findAllProbes();

    public ProbeDto findProbeById(int probeId);

    public RegionDto findRegion();

    public ProbeDto save(ProbeForm probeForm);

    public RegionDto save(RegionForm regionForm);

    public ProbeDto execute(int probeId, Instruction[] instructions);

    public void deleteProbe(int probeId);

    public void deleteAllProbes();

    public void deleteRegion();
}
