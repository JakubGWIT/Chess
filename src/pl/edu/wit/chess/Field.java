package pl.edu.wit.chess;

public class Field {
    private final Color color;
    private final int x;
    private final int y;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = (x + y) % 2 == 0 ? Color.WHITE : Color.BLACK;
    }
}
