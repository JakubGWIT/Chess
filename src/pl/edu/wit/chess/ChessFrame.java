package pl.edu.wit.chess;
import javax.swing.*;


public class ChessFrame extends JFrame{

    public ChessFrame() {
        super("Chess game");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640,640);
        setResizable(false);
        setLocationRelativeTo(null);
        Board board = new Board();
        getContentPane().add(board);
    }

}
