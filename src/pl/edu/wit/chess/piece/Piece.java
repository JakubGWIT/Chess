package pl.edu.wit.chess.piece;

import pl.edu.wit.chess.Color;
import pl.edu.wit.chess.Field;

import javax.swing.*;
import java.awt.*;

public abstract class Piece extends JLabel {
    private final Color color;
    private Field field;

    Piece(Color color, String iconWhite, String iconBlack) {
        this.color = color;
        String icon = color == Color.WHITE ? iconWhite : iconBlack;
        setText(icon);
        setFont(new Font(getFont().getFontName(), Font.PLAIN, 48));
    }

    public void setField(Field field) {
        this.field = field;
    }
}