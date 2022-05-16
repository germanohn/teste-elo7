package com.elo7.probes.api;

import com.elo7.probes.domain.Instruction;
import com.elo7.probes.dto.ProbeDto;
import com.elo7.probes.dto.RegionDto;
import com.elo7.probes.form.ProbeForm;
import com.elo7.probes.form.RegionForm;
import com.elo7.probes.service.Service;
import com.elo7.probes.service.ServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    private Service service = new ServiceImpl();

    @GetMapping("/probes")
    public List<ProbeDto> findAllProbes() {
        return service.findAllProbes();
    }

    @GetMapping("/probes/{probeId}")
    public ProbeDto getProbe(@PathVariable int probeId) {
        return service.findProbeById(probeId);
    }

    @GetMapping("/regions")
    public RegionDto getRegion() {
        return service.findRegion();
    }

    @PostMapping("/probes")
    public ProbeDto post(@RequestBody ProbeForm probeForm) {
        return service.save(probeForm);
    }

    @PostMapping("/regions")
    public RegionDto post(@RequestBody RegionForm regionForm) {
        return service.save(regionForm);
    }

    @PostMapping("/instructions/probes/{probeId}")
    public ProbeDto post(@PathVariable int probeId, @RequestBody Instruction instructions[]) {
        return service.execute(probeId, instructions);
    }

    @DeleteMapping("/probes/{probeId}")
    public void deleteProbe(@PathVariable int probeId) {
        service.deleteProbe(probeId);
    }

    @DeleteMapping("/probes")
    public void deleteAllProbes() {
        service.deleteAllProbes();
    }

    @DeleteMapping("/regions")
    public void deleteRegion() {
        service.deleteRegion();
    }
}
