package org.blackcat.Entity;
import java.util.Random;
public class Cell {
    private int state;
    private boolean verified = false;

    Coordinate coordinate;

    public Cell(int x, int y) {

        coordinate = new Coordinate(x, y);

        Random ran = new Random();
        this.state = ran.nextInt(2);
    }

    public int getState() {
        return state;
    }

    public int getX() {
        return coordinate.getX();
    }

    public int getY() {
        return coordinate.getY();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void kill() {
        state = 0;
    }

    public void aliveAgain() {
        state = 1;
    }

    public void setVerified(boolean val) {
        verified = val;
    }

    public boolean getVerified() {
        return verified;
    }
}
