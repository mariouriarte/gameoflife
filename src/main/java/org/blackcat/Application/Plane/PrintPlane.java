package org.blackcat.Application.Plane;

import org.blackcat.Entity.Cell;
import org.blackcat.Entity.AxisYCell;
import org.blackcat.Entity.AxisXCell;
import org.blackcat.Entity.Plane;

import java.util.Iterator;

public class PrintPlane {
    public AxisYCell axis;

    public PrintPlane(Plane plane) {
        this.axis = plane.getListAxisCell();
    }

    public void print() {
        Iterator<AxisXCell> itrY = axis.getAxis().iterator();

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
        String s = "o";
        if (cell.getState() == 0) {
            s = " ";
        }
        System.out.print(s);
    }
}
