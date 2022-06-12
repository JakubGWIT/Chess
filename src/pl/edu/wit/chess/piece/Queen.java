package pl.edu.wit.chess.piece;

import pl.edu.wit.chess.Color;
import pl.edu.wit.chess.piece.Piece;
public class Queen extends Piece { // IS-A
    public Queen(Color color) {
        super(color, "♕","♛");
    }
}