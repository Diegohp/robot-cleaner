package com.robotcleaner.domain.model;

public enum Orientation {
    N, E, S, W;

    /**
     * Method to allow Robot to face to the left position,
     * regarding currently orientation of Robot.
     * */
    public Orientation turnLeft() {
        return switch (this) {
            case N -> W;
            case W -> S;
            case S -> E;
            case E -> N;
        };
    }

    /**
     * Method to allow Robot to face to the right position,
     * regarding currently orientation of Robot.
     * */
    public Orientation turnRight() {
        return switch (this) {
            case N -> E;
            case E -> S;
            case S -> W;
            case W -> N;
        };
    }
}