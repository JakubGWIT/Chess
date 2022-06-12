package pl.edu.wit.chess.event;

import pl.edu.wit.chess.Field;
import pl.edu.wit.chess.piece.Piece;

import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.io.Serializable;

public class FieldDropListener extends DropTargetAdapter implements Serializable {

    private final Field target;


    public FieldDropListener(Field field){
        this.target = field;
    }

    @Override
    public void drop(final DropTargetDropEvent event){
        try {
            Transferable transferable = event.getTransferable();
            Object td = transferable.getTransferData(Piece.PIECE_DATA_FLAVOR);
            if (td instanceof Piece piece) {
//                Piece piece = (Piece) td;
                target.placePiece(piece);
                event.acceptDrop(DnDConstants.ACTION_MOVE);
                event.dropComplete(true);
            } else {
                event.rejectDrop();
                event.dropComplete(false);
            }

        } catch (Exception ex) {
            event.rejectDrop();
            event.dropComplete(false);
        }
    }
}
