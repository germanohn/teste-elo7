package com.elo7.probes.domain;

public class TwoDimensionalCartesianCoordinateSystem {
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

    public static int getDx(Direction direction) {
        return dx[direction.ordinal()];
    }

    public static int getDy(Direction direction) {
        return dy[direction.ordinal()];
    }
}
