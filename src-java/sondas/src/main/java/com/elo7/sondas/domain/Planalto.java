package com.elo7.sondas.domain;

/**
 * Planalto is the class that models a particular region of a Cartesian
 * Plane: a rectangle with minimum x and y coordinates equal to zero.
 *
 * Also, it provides a method to check if an integer is a valid x coordinate
 * of a fixed Planalto, and it provides a similar method for y-coordinate.
 */
public class Planalto {
    /**
     * The minimum x-coordinate in the "Planalto". It is input independent
     * and always equal to 0.
     */
    public static final int min_x = 0;

    /**
     * The minimum y-coordinate in the "Planalto". It is input independent
     * and always equal to 0.
     */
    public static final int min_y = 0;

    /**
     * The maximum x-coordinate in the "Planalto".
     */
    public static int max_x = 100;

    /**
     * The maximum y-coordinate in the "Planalto".
     */
    public static int max_y = 100;

    /**
     * Test if the x-coordinate will lie within the boundaries of the
     * "Planalto" in x-axis.
     *
     * @param  x the x-coordinate to be tested
     * @return   <code>true</code> if the x-coordinate lies within the
     *           boundaries of the "Planalto" x-axis;
     *           <code>false</code> otherwise.
     */
    public static boolean valid_x(int x) {
        return x >= Planalto.min_x && x <= Planalto.max_x;
    }

    /**
     * Test if the y-coordinate will lie within the boundaries of the
     * "Planalto" in the y-axis.
     *
     * @param  y the y-coordinate to be tested
     * @return   <code>true</code> if the y-coordinate lies within the
     *           boundaries of the "Planalto" y-axis;
     *           <code>false</code> otherwise.
     */
    public static boolean valid_y(int y) {
        return y >= Planalto.min_y && y <= Planalto.max_y;
    }
}
