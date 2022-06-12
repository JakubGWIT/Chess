package pl.edu.wit.chess;

import pl.edu.wit.chess.piece.Piece;

import javax.swing.*;

public class Field extends JPanel {
    private final Color color;
    private final int x;
    private final int y;
    private Piece piece;

    public Field(int x, int y) {
        Field field;
        this.x = x;
        this.y = y;
        this.color = (x + y) % 2 == 0 ? Color.WHITE : Color.BLACK;
        setBackground((color.toFieldColor()));
    }

    public void placePiece(Piece piece) {
        this.piece = piece;
        this.piece.setField(this);
        add(piece);
        invalidate();
        repaint();

    }

    public int getFieldY() {
        return y;
    }
    public int getFieldX() {
        return x;
    }
}