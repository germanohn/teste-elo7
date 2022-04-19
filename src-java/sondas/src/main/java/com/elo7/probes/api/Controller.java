package com.elo7.probes.api;

import com.elo7.probes.domain.Plateau;
import com.elo7.probes.domain.Probe;
import com.elo7.probes.service.Service;
import com.elo7.probes.service.ServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    private Service service = new ServiceImpl();

    @GetMapping("/probes")
    public List<Probe> findAllProbes() {
        return service.findAllProbes();
    }

    @GetMapping("/probes/{probeId}")
    public Probe getProbe(@PathVariable int probeId) {
        return service.findProbeById(probeId);
    }

    @GetMapping("/plateau")
    public Plateau getPlateau() {
        return service.findPlateau();
    }

    @PostMapping("/probes")
    public void post(@RequestBody Probe probe) {
        System.out.println("Receive Probe:");
        probe.printProbe();
        System.out.println();

        service.save(probe);
    }

    @PostMapping("/plateau")
    public void post(@RequestBody Plateau plateau) {
        service.save(plateau);

        System.out.println("Plateau saved successfully");
    }

    @DeleteMapping("/probes/{probeId}")
    public void deleteProbe(@PathVariable int probeId) {
        service.deleteProbe(probeId);
    }

    @DeleteMapping("/probes")
    public void deleteAllProbes() {
        service.deleteAllProbes();
    }

    @DeleteMapping("/plateau")
    public void deletePlateau() {
        service.deletePlateau();
    }
}
