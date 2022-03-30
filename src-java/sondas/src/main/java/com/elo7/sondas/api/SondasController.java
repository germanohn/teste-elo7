package com.elo7.sondas.api;

import com.elo7.sondas.domain.Sonda;
import com.elo7.sondas.domain.SondaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sondas")
public class SondasController {
    private SondaService service = new SondaService();

    @GetMapping()
    public List<Sonda> get() {
        return service.getSondas();
    }

    @PostMapping("/planalto")
    public String post(@RequestParam("max_x") int max_x,
                       @RequestParam("max_y") int max_y) {
        service.setPlanalto(max_x, max_y);

        return "Planalto salvo com sucesso";
    }

    @PostMapping("/sonda")
    public String post(@RequestParam("x") int x, @RequestParam("y") int y,
                       @RequestParam("direction") char direction,
                       @RequestParam("instructions") String instructions) {
        System.out.println("instructions received by post " + instructions);
        Sonda sonda = new Sonda(x, y, direction);
        service.save(sonda, instructions);

        return "Sonda na posição " + sonda.getX() + " " + sonda.getY() + " " +
                sonda.getDirection() + " salva com sucesso";
    }
}
