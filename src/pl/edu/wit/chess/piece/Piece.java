package pl.edu.wit.chess.piece;

import pl.edu.wit.chess.Color;
import pl.edu.wit.chess.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Piece extends JLabel implements Transferable {
    public static final DataFlavor PIECE_DATA_FLAVOR = new DataFlavor(Piece.class, "java/Piece");
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


    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{PIECE_DATA_FLAVOR};
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        return this;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) { // falvor=null
        //Yoda condition
        return PIECE_DATA_FLAVOR.equals(flavor); // NullPointerExeception
    }

    public Image getAsImage() {
        Image image = new BufferedImage(80, 80, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(java.awt.Color.BLACK);
        graphics.setFont(getFont());
        graphics.drawString(getText(), 0, 80);
        graphics.dispose();
        return image;
    }


}