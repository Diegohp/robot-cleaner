/*... Grid.java ...*/
package domain.model;

public class Grid {
    private final GridWidth gridWidth;
    private final GridLength gridLength;

    public Grid(GridWidth gridWidth, GridLength gridLength) {
        this.gridWidth = gridWidth;
        this.gridLength = gridLength;
    }

    /**
     * Method to check if position given as an input is still inside the Grid Layout
     * */
    public boolean isWithinGridBounds(Position position) {
        return position.getX() >= 0 && position.getX() <= gridWidth.getGridWidth() &&
                position.getY() >= 0 && position.getY() <= gridLength.getGridLength();
    }
}
