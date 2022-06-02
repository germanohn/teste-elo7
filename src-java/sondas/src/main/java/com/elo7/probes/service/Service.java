package com.elo7.probes.service;

import com.elo7.probes.domain.Instruction;
import com.elo7.probes.dto.ProbeDto;
import com.elo7.probes.dto.ShapeDto;
import com.elo7.probes.form.ProbeForm;

import java.util.List;

public interface Service {

    public List<ProbeDto> findAllProbes();

    public ProbeDto findProbeById(int probeId);

    public ShapeDto findRegion();

    public ProbeDto save(ProbeForm probeForm);

    public ShapeDto save(ShapeDto shapeDto);

    public ProbeDto execute(int probeId, Instruction[] instructions);

    public void deleteProbe(int probeId);

    public void deleteAllProbes();

    public void deleteRegion();
}
