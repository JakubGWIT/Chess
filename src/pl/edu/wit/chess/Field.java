package pl.edu.wit.chess;

import pl.edu.wit.chess.event.FieldDragListener;
import pl.edu.wit.chess.event.FieldDropListener;
import pl.edu.wit.chess.piece.Piece;

import java.awt.*;
import java.awt.dnd.*;
import java.util.Objects;
import javax.swing.*;

public class Field extends JPanel implements DragGestureListener {
    private final Color color;
    private final int x;
    private final int y;
    private Piece piece;

    private DropTarget target;
    private DropTargetListener listener;


    public Field(int x, int y) {
        Field field;
        this.x = x;
        this.y = y;
        this.color = (x + y) % 2 == 0 ? Color.WHITE : Color.BLACK;
        setBackground((color.toFieldColor()));
        DragSource.getDefaultDragSource()
                .createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE, this);
        this.listener = new FieldDropListener(this);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        target = new DropTarget(this, DnDConstants.ACTION_MOVE, listener, true);
    }

    @Override
    public void removeNotify() {
        super.removeNotify();
        target.removeDropTargetListener(listener);
    }

    public void placePiece(Piece piece) {
        this.piece = piece;
        this.piece.setField(this);
        add(piece);
        invalidate();
        repaint();

    }

    public void clearPiece() {
        Objects.requireNonNull(piece);
        this.piece = null;
        removeAll();
        invalidate();
        repaint();
    }

    public boolean isNotEmpty() {
        return Objects.nonNull(piece);
    }

    public int getFieldY() {
        return y;
    }

    public int getFieldX() {
        return x;
    }

    @Override
    public void dragGestureRecognized(final DragGestureEvent event) {
        if (isNotEmpty()) {
            Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
            DragSourceListener sourceListener = new FieldDragListener(this);
            Image image = piece.getAsImage();
            event.startDrag(cursor, image, new Point(40, 40), piece, sourceListener);
        }
    }
}

