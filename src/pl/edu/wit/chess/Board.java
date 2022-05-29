package pl.edu.wit.chess;

import pl.edu.wit.chess.Field;
import pl.edu.wit.chess.piece.Pawn;
import javax.swing.*;
import java.awt.*;

public class Board  extends JPanel{
    public final static int SIZE = 8;
    private final Field[][] fields;

    public Board() {
        fields = new Field[SIZE][SIZE];
        init();
        setLayout(new GridLayout(SIZE, SIZE));
    }

    public void init() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                Field field = new Field(x,y);
                fields[y][x] = field;
                initPiece(field);
                add(field);
            }
        }
    }

    private void initPiece(Field field){
        int y = field.getFieldY();
        Color pieceColor = field.getFieldY() == 1 || field.getFieldY() == 0
                ? Color.BLACK
                : Color.WHITE;

        if (y == 1 || y == 6){
            Pawn pawn = new Pawn(pieceColor);
            field.placePiece(pawn);
        }

    }
}
