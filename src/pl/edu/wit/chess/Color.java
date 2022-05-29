package pl.edu.wit.chess;

public enum Color {
    WHITE, BLACK;

    public java.awt.Color toFieldColor(){
        return switch (this){
            case WHITE -> new java.awt.Color(255, 206, 158);
            case BLACK -> new java.awt.Color(209,139,71);
        };
    }
}
