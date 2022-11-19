package org.blackcat.Entity;

public class Plane {
    private AxisYCell axisYCell;
    private int sides;

    public Plane(int sides) {
        this.sides = sides;
        axisYCell = new AxisYCell(sides);
        initializeSides();
    }

    private void initializeSides() {
        for (int j = 0; j < sides; j++) {
            for (int i = 0; i < sides; i++) {
                Cell cell = new Cell(i, j);
                axisYCell.addCellInCoordinateY(j, cell);
            }
        }
    }

    public Cell getCellPosXY(Coordinate coordinate) {
        return axisYCell.getCellPosXY(coordinate);
    }

    public int getSides() {
        return sides;
    }

    public AxisXCell getLinealCells() {
        return axisYCell.getLinealCells();
    }

    public AxisYCell getListAxisCell() {
        return axisYCell;
    }
}
