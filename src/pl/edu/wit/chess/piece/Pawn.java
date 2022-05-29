package pl.edu.wit.chess.piece;

import pl.edu.wit.chess.Color;
import pl.edu.wit.chess.piece.Piece;
public class Pawn extends Piece { // IS-A
    public Pawn(Color color) {
        super(color, "♙","♟");
    }
}
