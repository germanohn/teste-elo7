package com.elo7.probes.domain;

import org.jetbrains.annotations.NotNull;

public class OrientedPosition {
    private Position position;
    private Direction direction;

    /**
     * Default constructor for OrientedPosition
     */
    public OrientedPosition() {
        this.position = new Position();
        this.direction = Direction.N;
    }

    /**
     *
     *
     * @param position
     * @param direction
     */
    public OrientedPosition(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    // TODO: Add try block to check if it is a valid instruction
    public void rotate(@NotNull Instruction instruction) {
        final int MOD = 4;
        Direction[] directions = Direction.values();

        int directionIndex = (this.direction.ordinal() +
                                instruction.getValue() + MOD) % MOD;
        this.direction = directions[directionIndex];
    }

    /**
     *
     * @return
     */
    public OrientedPosition nextOrientedPosition() {
        Position nextPosition =
                new Position(position.getX() +
                        TwoDimensionalCartesianCoordinateSystem.getDx(direction),
                             position.getY() +
                         TwoDimensionalCartesianCoordinateSystem.getDy(direction));
        return new OrientedPosition(nextPosition, direction);
    }

    public void printOrientedPosition() {
        this.position.printPosition();
        System.out.print(" " + this.direction.toString());
    }
}
