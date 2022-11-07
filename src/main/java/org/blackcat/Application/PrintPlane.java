package org.blackcat.Application;

import org.blackcat.Entity.Cell;

import java.util.Iterator;
import java.util.List;

public class PrintPlane {
    public List<List<Cell>> axis;

    public PrintPlane(Plane plane) {
        this.axis = plane.axis;
    }

    public void print() {

        Iterator<List<Cell>> itrY = this.axis.listIterator();

        while (itrY.hasNext()) {

            Iterator<Cell> itrX = itrY.next().iterator();

            while (itrX.hasNext()) {
                Cell cell = itrX.next();
                System.out.print(cell.getState());
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}
