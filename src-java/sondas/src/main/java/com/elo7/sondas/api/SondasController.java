package com.elo7.sondas.api;

import com.elo7.sondas.domain.Sonda;
import com.elo7.sondas.domain.SondaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class to handle the HTTP requests "get" and "post".
 */
@RestController
@RequestMapping("/api/v1/sondas")
public class SondasController {
    private SondaService service = new SondaService();

    /**
     * Gets the Sonda objects that exist in the Planalto so far.
     *
     * @return list of Sonda objects that exist in the Planalto so far.
     */
    @GetMapping()
    public List<Sonda> get() {
        return service.getSondas();
    }

    /**
     * Sets the maximum x and y coordinates of the Planalto.
     *
     * @param max_x the maximum x-coordinate of the Planalto.
     * @param max_y the maximum y-coordinate of the Planalto.
     * @return      a message that confirms the setting.
     */
    @PostMapping("/planalto")
    public String post(@RequestParam("max_x") int max_x,
                       @RequestParam("max_y") int max_y) {
        service.setPlanalto(max_x, max_y);

        return "Planalto configurado com sucesso";
    }

    /**
     * Processes a HTTP post request that perform instructions on a Sonda
     * object, and then add it with its new position and cardinal direction
     * in the list sondas.
     *
     * @param x            the x-coordinate of the Sonda object.
     * @param y            the y-coordinate of the Sonda object.
     * @param direction    the cardinal direction of the Sonda object.
     * @param instructions String of instructions for the Sonda object sonda.
     * @return             a message that confirms the execution of the post
     *                     request.
     */
    @PostMapping("/sonda")
    public String post(@RequestParam("x") int x, @RequestParam("y") int y,
                       @RequestParam("direction") char direction,
                       @RequestParam("instructions") String instructions) {
        Sonda sonda = new Sonda(x, y, direction);
        service.save(sonda, instructions);

        return "Sonda na posição " + sonda.getX() + " " + sonda.getY() + " " +
                sonda.getDirection() + " salva com sucesso";
    }
}
