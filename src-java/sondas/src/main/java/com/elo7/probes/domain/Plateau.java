package com.elo7.probes.domain;

import java.util.Arrays;

/**
 * Plateau is the class that models a particular region of a Cartesian
 * Plane: a rectangle with minimum x and y coordinates equal to zero.
 *
 * Also, it provides a method to check if an integer is a valid x coordinate
 * of a fixed Plateau, and it provides a similar method for y-coordinate.
 */
public class Plateau {
    /**
     * The minimum x-coordinate in the "Plateau". It is input independent
     * and always equal to 0.
     */
    public static final int minX = 0;

    /**
     * The minimum y-coordinate in the "Plateau". It is input independent
     * and always equal to 0.
     */
    public static final int minY = 0;

    /**
     * The maximum x-coordinate in the "Plateau".
     */
    private int maxX;

     /**
     * The maximum y-coordinate in the "Plateau".
     */
    private int maxY;

    private Location[][] locations;

    /**
     * The variation of x-coordinate when moving the probe one unit in each
     * cardinal direction ('N': dx[0], 'E': dx[1], 'S': dx[2], 'W': dx[3])
     */
    private static final int[] dx = {0, 1, 0, -1}; // N, E, S, W

    /**
     * The variation of y-coordinate when moving the probe one unit in each
     * cardinal direction ('N': dx[0], 'E': dx[1], 'S': dx[2], 'W': dx[3])
     */
    private static final int[] dy = {1, 0, -1, 0}; // N, E, S, W

    /**
     * Default Constructor
     */
    public Plateau() {
        this.maxX = 0;
        this.maxY = 0;
        locations = new Location[1][1];
        locations[0][0] = Location.F;
    }

    /**
     * Constructor
     * @param maxX
     * @param maxY
     */
    public Plateau(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        locations = new Location[this.maxX + 1][this.maxY + 1];
        for (Location[] row : locations) {
            Arrays.fill(row, Location.F);
        }
    }

    public Plateau(int maxX, int maxY, Location[][] locations) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.locations = locations;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public static int getDx(Direction direction) {
        return dx[direction.ordinal()];
    }

    public static int getDy(Direction direction) {
        return dy[direction.ordinal()];
    }

    public boolean isLocationFree(Position position) {
        return this.locations[position.getX()][position.getY()].equals(Location.F);
    }

    public boolean isPositionValid(Position position) {
        return isXCoordinateValid(position.getX()) &&
                isYCoordinateValid(position.getY());
    }

    /**
     * Test if the x-coordinate will lie within the boundaries of the
     * "Plateau" in x-axis.
     *
     * @param  x the x-coordinate to be tested
     * @return   <code>true</code> if the x-coordinate lies within the
     *           boundaries of the "Plateau" x-axis;
     *           <code>false</code> otherwise.
     */
    public boolean isXCoordinateValid(int x) {
        return x >= Plateau.minX && x <= this.maxX;
    }

    /**
     * Test if the y-coordinate will lie within the boundaries of the
     * "Plateau" in the y-axis.
     *
     * @param  y the y-coordinate to be tested
     * @return   <code>true</code> if the y-coordinate lies within the
     *           boundaries of the "Plateau" y-axis;
     *           <code>false</code> otherwise.
     */
    public boolean isYCoordinateValid(int y) {
        return y >= Plateau.minY && y <= this.maxY;
    }
}
