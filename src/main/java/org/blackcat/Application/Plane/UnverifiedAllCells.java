package org.blackcat.Application.Plane;

import org.blackcat.Entity.Cell;
import org.blackcat.Entity.AxisXCell;
import org.blackcat.Entity.Plane;

import java.util.Iterator;

public class UnverifiedAllCells {

    public static void unverified(Plane plane) {

        AxisXCell axisXCell = plane.getLinealCells();
        Iterator<Cell> itr = axisXCell.getList().iterator();

        while (itr.hasNext()) {
            Cell cell = itr.next();
            cell.setVerified(false);
        }
    }
}
