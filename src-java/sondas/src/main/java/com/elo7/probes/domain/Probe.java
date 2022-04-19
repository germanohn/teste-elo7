package com.elo7.probes.domain;

import org.apache.commons.lang3.EnumUtils;

/**
 * Probe is the class that models a "Probe" (in english probe) navigating
 * through a "Planalto" (in english plateau; see class <code>Planalto</code>).
 * <p>
 * It implements the three basic movements of such object: to move a Probe
 * object either to the left or to the right by 90°, or to move one unit, on
 * the plateau where it lies, in the cardinal direction in which it points.
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

    /**
     * Gets the oriented position of the Probe object
     *
     * @return the oriented position of the object
     */
    public OrientedPosition getOrientedPosition() {
        return orientedPosition;
    }

    public void setOrientedPosition(Plateau plateau, OrientedPosition orientedPosition) {
        if (plateau.isPositionValid(orientedPosition.getPosition()) &&
                plateau.isLocationFree(orientedPosition.getPosition())) {
            this.orientedPosition = orientedPosition;
        }
        this.orientedPosition = orientedPosition;
    }

    /**
     * Processes one of the following instructions to move the Probe object this:
     * 'L' rotates 90° to the left; 'R' rotates 90° to the right; 'M' move
     * <code>this</code> one unit according to <code>direction</code>.
     *
     * @param instruction the instruction to move the "Probe": 'L'; 'R'; 'M'.
     */
    public void move(Plateau plateau, Instruction instruction) {
        System.out.println("Start of method move of Probe class, instruction " + instruction.toString());
        if (!EnumUtils.isValidEnum(Instruction.class, instruction.toString())) {
            System.out.println("Invalid instruction");
        } else if (instruction.equals(Instruction.M)) {
            OrientedPosition nextOrientedPosition =
                    this.orientedPosition.nextOrientedPosition();
            // Get response from set and return a message
            this.setOrientedPosition(plateau, nextOrientedPosition);
        } else { // instruction == L or instruction == R
            orientedPosition.rotate(instruction);
        }
    }

    public void printProbe() {
        this.orientedPosition.printOrientedPosition();
    }
}
