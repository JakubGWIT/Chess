package pl.edu.wit.chess.event;

import pl.edu.wit.chess.Field;

import java.awt.dnd.DragSourceAdapter;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceListener;

public class FieldDragListener extends DragSourceAdapter {

    private final Field source;

    public FieldDragListener(Field field){
        this.source = field;
    }


    @Override
    public void dragDropEnd(final DragSourceDropEvent event) {
        if (event.getDropSuccess()) {
            source.clearPiece();
        }
    }
}
