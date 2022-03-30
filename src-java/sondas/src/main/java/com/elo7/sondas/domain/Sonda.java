package com.elo7.sondas.domain;

import java.util.TreeMap;

public class Sonda {
    private int x, y;
    private char direction;

    public static final TreeMap<Character, Integer> number_of_direction =
            new TreeMap<>();
    public static final TreeMap<Integer, Character> symbol_of_direction =
            new TreeMap<>();
    public static final TreeMap<Character, Integer> rotation = new TreeMap<>();
    public static final int[] dx = {0, 1, 0, -1}; // N, E, S, W
    public static final int[] dy = {1, 0, -1, 0}; // N, E, S, W

    static {
        number_of_direction.put('N', 0);
        number_of_direction.put('E', 1);
        number_of_direction.put('S', 2);
        number_of_direction.put('W', 3);

        symbol_of_direction.put(0, 'N');
        symbol_of_direction.put(1, 'E');
        symbol_of_direction.put(2, 'S');
        symbol_of_direction.put(3, 'W');

        rotation.put('L', -1);
        rotation.put('R', +1);
    }

    // constructors
    public Sonda() {}

    public Sonda(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getDirection() {
        return direction;
    }

    // Receive a instruction ('L': rotate 90° left, 'R': rotate 90° right,
    // or 'M': move) and change the "sonda" position accordingly
    public void move(char instruction) {
        if (instruction == 'L' || instruction == 'R') {
            final int MOD = 4;
            int number_new_direction = (number_of_direction.get(direction) +
                                        rotation.get(instruction) + MOD) % MOD;
            direction = symbol_of_direction.get(number_new_direction);
        } else { // instruction == 'M'
            if (sonda_valid_move(this)) {
                x += dx[number_of_direction.get(direction)];
                y += dy[number_of_direction.get(direction)];
            }
        }
    }

    public void print_position() {
        /*int x = sonda.getX();
        int y = sonda.getY();
        int direction = sonda.getDirection();*/
        System.out.println(x + " " + y + " " + direction);
    }

    // auxiliary functions
    private boolean valid_x(int x) {
        return x >= 0 && x <= Main.max_x;
    }

    private boolean valid_y(int y) {
        return y >= 0 && y <= Main.max_y;
    }

    private boolean sonda_valid_move(Sonda sonda) {
        return valid_x(sonda.getX() +
                dx[number_of_direction.get(sonda.getDirection())]) &&
               valid_y(sonda.getY() +
                dy[number_of_direction.get(sonda.getDirection())]);
    }
}
