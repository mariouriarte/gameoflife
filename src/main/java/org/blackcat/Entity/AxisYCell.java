package org.blackcat.Entity;

import java.util.ArrayList;
import java.util.List;

public class AxisYCell {
    private List<AxisXCell> axis = new ArrayList();
    AxisXCell linealCells = new AxisXCell();

    public AxisYCell(int sides) {
        for (int i = 0; i < sides; i++) {
            axis.add(new AxisXCell());
        }
    }

    public void addCellInCoordinateY(int y, Cell cell) {
        AxisXCell list = getListInCoordinateY(y);
        list.add(cell);
        linealCells.add(cell);
    }

    public Cell getCellPosXY(Coordinate coordinate) {
        AxisXCell ejeY = getListInCoordinateY(coordinate.getY());
        Cell cell = ejeY.getCellInX(coordinate.getX());
        return cell;
    }

    public AxisXCell getListInCoordinateY(int y){
        return axis.get(y);
    }

    public List<AxisXCell> getAxis() {
        return axis;
    }

    public AxisXCell getLinealCells() {
        return linealCells;
    }
}
