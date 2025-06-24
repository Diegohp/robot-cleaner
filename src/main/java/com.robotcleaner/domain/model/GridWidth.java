package com.robotcleaner.domain.model;

public class GridWidth {
    private final int maxX;

    public GridWidth(int maxX) {
        this.maxX = maxX;
    }

    public int getGridWidth() {
        return maxX;
    }
}