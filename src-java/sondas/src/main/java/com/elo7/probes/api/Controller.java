package com.elo7.probes.api;

import com.elo7.probes.domain.Plateau;
import com.elo7.probes.domain.Probe;
import com.elo7.probes.domain.ProbeRegister;
import com.elo7.probes.domain.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    private Service service = new Service();

    @GetMapping("/probes")
    public List<Probe> get() { return service.getProbes(); }

    @PostMapping("/plateau")
    public void post(@RequestBody Plateau plateau) {
        service.setPlateau(plateau);

        System.out.println("Plateau saved successfully");
    }

    @PostMapping("/probes")
    public void post(@RequestBody Probe probe) {
        System.out.println("Receive Probe:");
        probe.printProbe();
        System.out.println();

        service.save(probe);
    }

    @PostMapping("/probesplusinstructions")
    public void post(@RequestBody ProbeRegister probeRegister) {
        service.save(probeRegister.getProbe(), probeRegister.getInstructions());
    }
}
