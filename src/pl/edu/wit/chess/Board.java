package pl.edu.wit.chess;

import pl.edu.wit.chess.Field;
import pl.edu.wit.chess.piece.Pawn;
import pl.edu.wit.chess.piece.Rook;
import pl.edu.wit.chess.piece.Knight;
import pl.edu.wit.chess.piece.Bishop;
import pl.edu.wit.chess.piece.Queen;
import pl.edu.wit.chess.piece.King;
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

        int x = field.getFieldX();
        Color pieceColorx = field.getFieldX() == 1 || field.getFieldX() == 0
                ? Color.BLACK
                : Color.WHITE;

        if (y == 1 || y == 6){
            Pawn pawn = new Pawn(pieceColor);
            field.placePiece(pawn);
        }
        if (y == 0 || y == 7){
            if(x == 0 || x==7){
            Rook rook = new Rook(pieceColor);
            field.placePiece(rook);}
        }
        if (y == 0 || y == 7){
            if(x == 1 || x==6){
                Knight knight = new Knight(pieceColor);
                field.placePiece(knight);}
        }
        if (y == 0 || y == 7){
            if(x == 2 || x==5){
                Bishop bishop = new Bishop(pieceColor);
                field.placePiece(bishop);}
        }

        if (y == 0 || y == 7){
            if(x == 3){
                Queen queen = new Queen(pieceColor);
                field.placePiece(queen);}
        }
        if (y == 0 || y == 7){
            if(x == 4){
                King king = new King(pieceColor);
                field.placePiece(king);}
        }

    }
}
