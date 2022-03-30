package com.elo7.sondas.domain;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Planalto.max_x = scanner.nextInt();
        Planalto.max_y = scanner.nextInt();

        // System.out.println("max_x " + max_x + " max_y " + max_y);

        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char direction = scanner.next().charAt(0);
            Sonda sonda = new Sonda(x, y, direction);

            scanner.nextLine();
            String instructions = scanner.nextLine();
            /* System.out.println("x " + x + " y " + y);
            System.out.println("direction " + direction);
            System.out.println("instructions " + instructions)*/
            for (char instruction : instructions.toCharArray()) {
                sonda.move(instruction);
            }

            sonda.print_position();
        }
    }
}
