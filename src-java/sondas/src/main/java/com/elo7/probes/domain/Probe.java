package com.elo7.probes.domain;

import com.elo7.probes.exception.EntityNotFoundException;
import com.elo7.probes.exception.MovementException;

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
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrientedPosition getOrientedPosition() {
        return orientedPosition;
    }

    public void setOrientedPosition(Region region, OrientedPosition orientedPosition) {
        if (region == null) {
            throw new EntityNotFoundException("Region not found");
        }

        Position position = orientedPosition.getPosition();
        if (!region.isPositionInside(position)) {
            throw new MovementException("Position (" + position.getX() + ", " +
                    position.getY() + ") is invalid in region");
        }

        if (!region.isPositionFree(position)) {
            throw new MovementException("Position (" + position.getX() + ", " +
                    position.getY() + ") already occupied with " +
                    region.getPositionStatusIn(position).name());
        }

        this.orientedPosition = orientedPosition;
    }

    public void land(Region region) {

        this.setOrientedPosition(region, this.orientedPosition);
        region.fillPosition(this.orientedPosition.getPosition(), PositionStatus.Probe);
    }

    /**
     * Processes one of the following instructions to move the Probe object this:
     * 'L' rotates 90° to the left; 'R' rotates 90° to the right; 'M' move
     * <code>this</code> one unit according to <code>direction</code>.
     *
     * @param instruction the instruction to move the "Probe": 'L'; 'R'; 'M'.
     */
    public void move(Region region, Instruction instruction) {
        if (instruction.equals(Instruction.M)) {
            OrientedPosition nextOrientedPosition =
                    this.orientedPosition.nextOrientedPosition();

            this.setOrientedPosition(region, nextOrientedPosition);

            region.freePosition(this.orientedPosition.getPosition());
            region.fillPosition(nextOrientedPosition.getPosition(), PositionStatus.Probe);
        } else { // instruction == L or instruction == R
            orientedPosition.rotate(instruction);
        }
    }

    public void move(Region region, Instruction[] instructions) {
        System.out.println("Start of method move of Probe class, multiple instructions ");
        for (Instruction instruction : instructions) {
            this.move(region, instruction);
        }
    }

    public void printProbe() {
        this.orientedPosition.printOrientedPosition();
    }
}
