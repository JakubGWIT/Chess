package pl.edu.wit.chess;

public class Board {
    public final static int SIZE = 8;
    private final Field[][] fields;

    public Board() {
        fields = new Field[SIZE][SIZE];
    }

    public void init() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                fields[y][x] = new Field(x, y);
            }
        }
    }
}
