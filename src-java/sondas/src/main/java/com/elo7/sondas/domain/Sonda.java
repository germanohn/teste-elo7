package com.elo7.sondas.domain;

import java.util.TreeMap;

/**
 * Sonda is the class that models a "sonda" (in english probe) navigating
 * through a "Planalto" (in english plateau; see class <code>Planalto</code>).
 * <p>
 * It implements the three basic movements of such object: to move a Sonda
 * object either to the left or to the right by 90°, or to move one unit, on
 * the plateau where it lies, in the cardinal direction in which it points.
 */
public class Sonda {
    private int x, y;
    private char direction;

    /**
     * Maps the cardinal directions 'N', 'E', 'S', and 'W' to the integers
     * '0', '1', '2', '3', respectively, to facilitate the movement of the
     * "sondas".
     */
    private static final TreeMap<Character, Integer> number_of_direction =
            new TreeMap<>();

    /**
     * Reverse of number_of_direction map
     */
    private static final TreeMap<Integer, Character> symbol_of_direction =
            new TreeMap<>();

    /**
     * Maps the instructions 'L' and 'R' to '-1' and '+1' to facilitate the
     * movement of the "sondas".
     */
    private static final TreeMap<Character, Integer> number_of_rotation =
            new TreeMap<>();

    /**
     * The variation of x-coordinate when moving the "sonda" one unit in each
     * cardinal direction ('N': dx[0], 'E': dx[1], 'S': dx[2], 'W': dx[3])
     */
    private static final int[] dx = {0, 1, 0, -1}; // N, E, S, W

    /**
     * The variation of y-coordinate when moving the "sonda" one unit in each
     * cardinal direction ('N': dx[0], 'E': dx[1], 'S': dx[2], 'W': dx[3])
     */
    private static final int[] dy = {1, 0, -1, 0}; // N, E, S, W

    static {
        number_of_direction.put('N', 0);
        number_of_direction.put('E', 1);
        number_of_direction.put('S', 2);
        number_of_direction.put('W', 3);

        symbol_of_direction.put(0, 'N');
        symbol_of_direction.put(1, 'E');
        symbol_of_direction.put(2, 'S');
        symbol_of_direction.put(3, 'W');

        number_of_rotation.put('L', -1);
        number_of_rotation.put('R', +1);
    }

    /**
     * Default class constructor
     */
    public Sonda() {}

    /**
     * Constructor that receives the position, the x and y coordinates, and the
     * cardinal direction of the new Sonda.
     *
     * @param x         the x-coordinate position of the new Sonda
     * @param y         the x-coordinate position of the new Sonda
     * @param direction the cardinal direction of the new Sonda
     */
    public Sonda(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    /**
     * Gets the x-coordinate of the object
     *
     * @return the integer relative to the x-coordinate of the object
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the object
     *
     * @return the integer relative to the x-coordinate of the object
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the cardinal direction of the object
     *
     * @return a character in {'N', 'E', 'S', 'W'} relative to the cardinal
     *         direction of the object
     */
    public char getDirection() {
        return direction;
    }

    /**
     * Process one of the following instructions to move the Sonda object this:
     * 'L' rotates 90° to the left; 'R' rotates 90° to the right; 'M' move
     * <code>this</code> one unit according to <code>direction</code>.
     *
     * @param instruction the instruction to move the "sonda": 'L'; 'R'; 'M'.
     */
    public void move(char instruction) {
        if (instruction == 'L' || instruction == 'R') {
            final int MOD = 4;
            int number_new_direction = (number_of_direction.get(direction) +
                                        number_of_rotation.get(instruction) +
                                        MOD) % MOD;
            direction = symbol_of_direction.get(number_new_direction);
        } else { // instruction == 'M'
            if (is_valid_to_move(this)) {
                x += dx[number_of_direction.get(direction)];
                y += dy[number_of_direction.get(direction)];
            } else {
                System.out.println("Invalid move");
            }
        }
    }

    /**
     * Print the current position and direction of the Sonda object this, that
     * is, its coordinates x and y and its cardinal direction.
     */
    public void print_position() {
        System.out.println(x + " " + y + " " + direction);
    }

    /**
     * Test whether the Sonda object coordinates will lie within the
     * boundaries of the "Planalto" if we move it one unit in its cardinal
     * direction.
     *
     * @param  sonda the Sonda object to have its position validated
     * @return       <code>true</code> if the Sonda object position is valid;
     *               <code>false</code> otherwise.
     */
    private boolean is_valid_to_move(Sonda sonda) {
        return Planalto.valid_x(sonda.getX() +
                dx[number_of_direction.get(sonda.getDirection())]) &&
                Planalto.valid_y(sonda.getY() +
                        dy[number_of_direction.get(sonda.getDirection())]);
    }
}
