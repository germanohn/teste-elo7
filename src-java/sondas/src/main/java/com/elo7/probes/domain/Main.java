package com.elo7.probes.domain;

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
        int maxX = scanner.nextInt();
        int maxY = scanner.nextInt();
        Plateau plateau = new Plateau(maxX, maxY);

        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String direction = scanner.next();
            Probe probe = new Probe(new OrientedPosition(
                    new Position(x, y), Direction.valueOf(direction)));

            scanner.nextLine();
            String instructions = scanner.nextLine();
            for (int i = 0; i < instructions.length(); i++) {
                probe.move(plateau, Instruction.valueOf(
                        instructions.substring(i, i + 1)));
            }

            probe.printProbe();
            System.out.println();
        }
    }
}
