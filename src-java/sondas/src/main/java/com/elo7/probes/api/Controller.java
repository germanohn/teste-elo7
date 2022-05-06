package com.elo7.probes.api;

import com.elo7.probes.domain.InstructionCommand;
import com.elo7.probes.domain.Region;
import com.elo7.probes.domain.Probe;
import com.elo7.probes.service.Service;
import com.elo7.probes.service.ServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class Controller {
    private Service service = new ServiceImpl();

    @GetMapping("/probes")
    public Collection<Probe> findAllProbes() {
        return service.findAllProbes();
    }

    @GetMapping("/probes/{probeId}")
    public Probe getProbe(@PathVariable int probeId) {
        // TODO: if returned probe is null, throw an exception


        return service.findProbeById(probeId);
    }

    @GetMapping("/regions")
    public Region getRegion() {
        return service.findRegion();
    }

    @PostMapping("/probes")
    public Probe post(@RequestBody Probe probe) {
        System.out.println("Receive Probe:");
        probe.printProbe();
        System.out.println();

        service.save(probe);

        return probe;
    }

    @PutMapping("/probes")
    public Probe put(@RequestBody Probe probe) {
        System.out.println("Receive Probe:");
        probe.printProbe();
        System.out.println();

        service.save(probe);

        return probe;
    }

    @PostMapping("/regions")
    public Region post(@RequestBody Region region) {
        service.save(region);

        System.out.println("Region saved successfully");

        return region;
    }

    @PutMapping("/regions")
    public Region put(@RequestBody Region region) {
        service.save(region);

        System.out.println("Region saved successfully");

        return region;
    }

    @PostMapping("/instructions/probes")
    public Probe post(@RequestBody InstructionCommand instructionCommand) {
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
