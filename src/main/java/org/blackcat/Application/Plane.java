package org.blackcat.Application;

import org.blackcat.Entity.Cell;

import java.util.ArrayList;
import java.util.List;

public class Plane {
    public List<List<Cell>> axis = new ArrayList<List<Cell>>();
    PrintPlane print = new PrintPlane(this);;

    private int sides;

    public Plane(int sides) {
        this.sides = sides;
        fillAxis();
    }

    private void fillAxis() {
        for (int j = 0; j < sides; j++) {
            List<Cell> planeX = new ArrayList<Cell>();
            for (int i = 0; i < sides; i++) {
                Cell cell = new Cell(i, j);
                planeX.add(cell);
            }
            axis.add(planeX);
        }
    }

    public void print() {
        print.print();
    }

    public Cell getCellPosXY(int x, int y) {
        List<Cell> ejeY = axis.get(y);
        Cell cell = ejeY.get(x);
        return cell;
    }

    public int getSides() {
        return sides;
    }
}
