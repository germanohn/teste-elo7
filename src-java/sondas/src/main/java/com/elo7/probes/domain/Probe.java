package com.elo7.probes.domain;

import org.apache.commons.lang3.EnumUtils;

/**
 * Probe is the class that models a "Probe" (in english probe) navigating
 * through a "Planalto" (in english region; see class <code>Planalto</code>).
 * <p>
 * It implements the three basic movements of such object: to move a Probe
 * object either to the left or to the right by 90°, or to move one unit, on
 * the region where it lies, in the cardinal direction in which it points.
 */
public class Probe {
    private int id;
    private OrientedPosition orientedPosition;

    /**
     * Default class constructor
     */
    public Probe() {
        this.id = 0;
        this.orientedPosition = new OrientedPosition();
    }

    public Probe(OrientedPosition orientedPosition) {
        this.id = 0;
        this.orientedPosition = orientedPosition;
    }

    public Probe(int id, OrientedPosition orientedPosition) {
        this.id = id;
        this.orientedPosition = orientedPosition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void land(Region region) {
        this.setOrientedPosition(region, this.orientedPosition);
    }

    /**
     * Processes one of the following instructions to move the Probe object this:
     * 'L' rotates 90° to the left; 'R' rotates 90° to the right; 'M' move
     * <code>this</code> one unit according to <code>direction</code>.
     *
     * @param instruction the instruction to move the "Probe": 'L'; 'R'; 'M'.
     */
    public void move(Region region, Instruction instruction) {
        System.out.println("Start of method move of Probe class, instruction " + instruction.toString());
        if (!EnumUtils.isValidEnum(Instruction.class, instruction.toString())) {
            System.out.println("Invalid instruction");
        } else if (instruction.equals(Instruction.M)) {
            OrientedPosition nextOrientedPosition =
                    this.orientedPosition.nextOrientedPosition();

            // Get response from set and return a message
            this.setOrientedPosition(region, nextOrientedPosition);
        } else { // instruction == L or instruction == R
            orientedPosition.rotate(instruction);
        }
    }

    private void setOrientedPosition(Region region, OrientedPosition orientedPosition) {
        Position position = orientedPosition.getPosition();
        if (region.isPositionInside(position) && region.isPositionFree(position)) {
            this.orientedPosition = orientedPosition;
            return;
        }
        System.out.println("Cannot set this position; Position invalid for this region");
    }

    public void printProbe() {
        this.orientedPosition.printOrientedPosition();
    }
}
