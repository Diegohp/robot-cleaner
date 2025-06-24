package com.robotcleaner.domain.model;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method to allow robot to move one grid square,
     * given an Orientation
     * */
    public Position move(Orientation orientation) {
        return switch (orientation) {
            case N -> new Position(x, y + 1);
            case S -> new Position(x, y - 1);
            case E -> new Position(x + 1, y);
            case W -> new Position(x - 1, y);
        };
    }

    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
