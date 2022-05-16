package com.elo7.probes.service;

import com.elo7.probes.domain.InstructionCommand;
import com.elo7.probes.dto.ProbeDto;
import com.elo7.probes.dto.RegionDto;
import com.elo7.probes.form.ProbeForm;
import com.elo7.probes.form.RegionForm;

import java.util.List;

public interface Service {

    public List<ProbeDto> findAllProbes();

    public ProbeDto findProbeById(int probeId);

    public RegionDto findRegion();

    public void save(ProbeForm probeForm);

    public void save(RegionForm regionForm  );

    public ProbeDto execute(InstructionCommand instructionCommand);

    public void deleteProbe(int probeId);

    public void deleteAllProbes();

    public void deleteRegion();
}
