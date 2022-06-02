package com.elo7.probes.api;

import com.elo7.probes.domain.Instruction;
import com.elo7.probes.dto.ProbeDto;
import com.elo7.probes.dto.ShapeDto;
import com.elo7.probes.form.ProbeForm;
import com.elo7.probes.service.Service;
import com.elo7.probes.service.ServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
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
    public ProbeDto getProbe(@Positive @PathVariable int probeId) {
        return service.findProbeById(probeId);
    }

    @GetMapping("/regions")
    public ShapeDto getRegion() {
        return service.findRegion();
    }

    @PostMapping("/probes")
    public ProbeDto post(@Valid @RequestBody ProbeForm probeForm) {
        return service.save(probeForm);
    }

    @PostMapping("/regions")
    public ShapeDto post(@Valid @RequestBody ShapeDto shapeDto) {
        return service.save(shapeDto);
    }

    @PostMapping("/instructions/probes/{probeId}")
    public ProbeDto post(@Positive @PathVariable int probeId, @Valid @RequestBody Instruction instructions[]) {
        return service.execute(probeId, instructions);
    }

    @DeleteMapping("/probes/{probeId}")
    public void deleteProbe(@Positive @PathVariable int probeId) {
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
