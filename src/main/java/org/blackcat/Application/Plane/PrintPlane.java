package org.blackcat.Application.Plane;

import org.blackcat.Entity.Cell;
import org.blackcat.Entity.ListAxisCell;
import org.blackcat.Entity.ListCell;
import org.blackcat.Entity.Plane;

import java.util.Iterator;
import java.util.List;

public class PrintPlane {
    public ListAxisCell axis;

    public PrintPlane(Plane plane) {
        this.axis = plane.getListAxisCell();
    }

    public void print() {
        Iterator<ListCell> itrY = axis.getAxis().iterator();

        while (itrY.hasNext()) {

            Iterator<Cell> itrX = itrY.next().getList().iterator();

            while (itrX.hasNext()) {
                Cell cell = itrX.next();
                printState(cell);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private void printState(Cell cell) {
        char c = 79;
        if (cell.getState() == 0) {
            c = 45;
        }
        System.out.print(c);
    }
}
