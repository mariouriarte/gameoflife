package org.blackcat.Application.Plane;

import org.blackcat.Entity.Cell;
import org.blackcat.Entity.ListCell;
import org.blackcat.Entity.Plane;

import java.util.Iterator;

public class UnverifiedAllCells {

    public static void unverified(Plane plane) {

        ListCell listCell = plane.getLinealListOfCells();

        Iterator<Cell> itr = listCell.getList().iterator();

        while (itr.hasNext()) {
            Cell cell = itr.next();
            cell.setVerified(false);
        }
    }
}
