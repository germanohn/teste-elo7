package com.elo7.sondas.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SondaService {
    private List<Sonda> sondas = new ArrayList<>();

    public List<Sonda> getSondas() {
        return sondas;
    }

    public void save(int max_x, int max_y) {
        Planalto.max_x = max_x;
        Planalto.max_y = max_y;
    }

    public void save(Sonda sonda, @NotNull String instructions) {
        System.out.println(instructions);
        for (char instruction : instructions.toCharArray()) {
            sonda.move(instruction);
        }
        sonda.print_position();
        sondas.add(sonda);
    }
}
