package com.elo7.sondas.domain;

import java.util.Scanner;

/**
 * Class that processes instructions for a series of Sonda objects in a
 * Planalto, taking input from the console.
 */
public class Main {

    /**
     * Receive the maximum values for coordinates of the Planalto and manage
     * the execution of instructions to Sonda objects.
     *
     * @param args parameters are not used
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Planalto.max_x = scanner.nextInt();
        Planalto.max_y = scanner.nextInt();

        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char direction = scanner.next().charAt(0);
            Sonda sonda = new Sonda(x, y, direction);

            scanner.nextLine();
            String instructions = scanner.nextLine();
            for (char instruction : instructions.toCharArray()) {
                sonda.move(instruction);
            }

            sonda.print_position();
        }
    }
}
