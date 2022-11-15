package org.blackcat.Application.Plane;

import org.blackcat.Entity.Cell;
import org.blackcat.Entity.Coordinate;
import org.blackcat.Entity.Plane;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NeighboursCell {

    private List<Cell> neighbours = new ArrayList<Cell>();
    private final Plane plane;
    private final Cell cell;
    private Cell cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8;
    final int sides;

    public NeighboursCell(Plane plane, Cell cell) {
        this.plane = plane;
        sides = plane.getSides();
        this.cell = cell;

        getNearby();
    }

    private void getNearby() {
        Coordinate coordinate = cell.getCoordinate();

        meetTopCells(coordinate);
        meetCenterCells(coordinate);
        meetBottomCells(coordinate);

        neighbours.add(cell1);
        neighbours.add(cell2);
        neighbours.add(cell3);
        neighbours.add(cell5);
        neighbours.add(cell8);
        neighbours.add(cell7);
        neighbours.add(cell6);
        neighbours.add(cell4);
    }

    private void meetTopCells(Coordinate coordinate) {

        int x = coordinate.getX();
        int y = coordinate.getY();

        if (y == 0) {
            y = this.sides;
        }

        int x1 = x;
        if (x == 0) {
            x1 = this.sides;
        }
        cell1 = plane.getCellPosXY(new Coordinate(x1 - 1, y - 1));
        cell2 = plane.getCellPosXY(new Coordinate(x, y - 1));

        int x2 = x;
        if (x == (this.sides - 1)) {
            x2 = -1;
        }
        cell3 = plane.getCellPosXY(new Coordinate(x2 + 1, y - 1));
    }

    private void meetCenterCells(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();

        int x1 = x;
        if (x == 0) {
            x1 = this.sides;
        }
        cell4 = plane.getCellPosXY(new Coordinate(x1 - 1, y));

        int x2 = x;
        if (x == (this.sides - 1)) {
            x2 = -1;
        }
        cell5 = plane.getCellPosXY(new Coordinate(x2 + 1, y));
    }

    private void meetBottomCells(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();

        if (y == (this.sides - 1)) {
            y = -1;
        }

        int x1 = x;
        if (x == 0) {
            x1 = this.sides;
        }
        cell6 = plane.getCellPosXY(new Coordinate(x1 - 1, y + 1));

        cell7 = plane.getCellPosXY(new Coordinate(x, y + 1));

        int x2 = x;
        if (x == (this.sides - 1)) {
            x2 = -1;
        }
        cell8 = plane.getCellPosXY(new Coordinate(x2 + 1, y + 1));
    }

    public List<Cell> getNeighbours() {
        return neighbours;
    }

    public void print() {
        System.out.println("neighbours: ");
        System.out.println(cell1.getState() + "  " + cell2.getState() + "  " + cell3.getState());
        System.out.println(cell4.getState() + "  k  " + cell5.getState());
        System.out.println(cell6.getState() + "  " + cell7.getState() + "  " + cell8.getState());
    }

    public int numNeighboursAlive() {

        int numLives = 0;

        Iterator<Cell> itr = neighbours.iterator();

        while (itr.hasNext()) {
            Cell cell = itr.next();
            if (cell.getState() == 1) {
                numLives++;
            }
        }

        return numLives;
    }
}
