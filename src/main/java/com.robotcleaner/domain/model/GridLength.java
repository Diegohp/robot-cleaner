package domain.model;

public class GridLength {
    private final int maxY;

    public GridLength(int maxY) {
        this.maxY = maxY;
    }

    public int getGridLength() {
        return maxY;
    }
}
