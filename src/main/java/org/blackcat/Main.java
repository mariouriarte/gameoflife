package org.blackcat;

import org.blackcat.Application.NeighboursCell;
import org.blackcat.Application.Plane;
import org.blackcat.Entity.Cell;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Game of life");

        Plane plane = new Plane(20);
        plane.print();

        Cell cell = plane.getCellPosXY(1,1);
        System.out.println();
        System.out.println(cell.getState());

        NeighboursCell neighboursCell = new NeighboursCell(plane, cell);
        neighboursCell.print();
        System.out.println("");
        System.out.println(neighboursCell.numAlive() + " vivas");
    }
}
