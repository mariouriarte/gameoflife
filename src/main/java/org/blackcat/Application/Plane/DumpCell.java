package org.blackcat.Application.Plane;

import org.blackcat.Entity.Cell;
import org.blackcat.Entity.Coordinate;
import org.blackcat.Entity.Plane;

public class DumpCell {

    public static void cellInCoordinate(Plane plane, Coordinate coordinate) {

        Cell cell = plane.getCellPosXY(coordinate);
        System.out.println();
        System.out.println(cell.getState() + " in pos (" + cell.getX() + ", "+ cell.getY()+")");

        NeighboursCell neighboursCell = new NeighboursCell(plane, cell);
        neighboursCell.print();
        System.out.println(neighboursCell.numNeighboursAlive() + " vivas");
    }
}
