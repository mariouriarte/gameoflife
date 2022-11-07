package org.blackcat.Entity;
import java.util.Random;
public class Cell {
    private int x;
    private int y;
    private int state;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;

        Random ran = new Random();
        this.state = ran.nextInt(2);
    }

    public int getState() {
        return state;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void kill() {
        state = 0;
    }

    public void aliveAgain() {
        state = 1;
    }
}
