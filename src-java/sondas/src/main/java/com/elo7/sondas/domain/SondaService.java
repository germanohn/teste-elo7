package com.elo7.sondas.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to keep, retrieve, and update the list of Sonda objects, and to set the
 * Planalto properties.
 */
public class SondaService {
    private List<Sonda> sondas = new ArrayList<>();

    /**
     * Gets the list of Sonda objects, namely sondas, that exist in the
     * Planalto so far.
     *
     * @return list of Sonda objects in the Planalto
     */
    public List<Sonda> getSondas() {
        return sondas;
    }

    /**
     * Sets the maximum x and y coordinates in the Planalto.
     *
     * @param max_x the maximum x-coordinate in the Planalto.
     * @param max_y the maximum y-coordinate in the Planalto.
     */
    public void setPlanalto(int max_x, int max_y) {
        Planalto.max_x = max_x;
        Planalto.max_y = max_y;
    }

    /**
     * Perform instructions on a Sonda object, and then add it with its new
     * position and cardinal direction in the list sondas
     *
     * @param sonda        the Sonda object to receive instructions and be
     *                     added to the sondas list
     * @param instructions String of instructions for the Sonda object sonda
     * @return             the Sonda object added to the sondas list
     */
    public Sonda save(Sonda sonda, @NotNull String instructions) {
        for (char instruction : instructions.toCharArray()) {
            sonda.move(instruction);
        }
        sondas.add(sonda);

        return sonda;
    }
}
