package com.elo7.probes.api;

import com.elo7.probes.domain.InstructionCommand;
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
        service.save(probeForm);

        return new ProbeDto(probeForm.convertToProbe());
    }

    @PostMapping("/regions")
    public RegionDto post(@RequestBody RegionForm regionForm) {
        service.save(regionForm);

        return new RegionDto(regionForm.convertToRegion());
    }

    @PostMapping("/instructions/probes")
    public ProbeDto post(@RequestBody InstructionCommand instructionCommand) {
        return service.execute(instructionCommand);
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
