package domain.model;

public enum Instructions {
    L, R, M;

    public static Instructions fromChar(char c) {
        return switch (c) {
            case 'L' -> L;
            case 'R' -> R;
            case 'M' -> M;
            default -> throw new IllegalArgumentException("Invalid instruction: " + c);
        };
    }
}