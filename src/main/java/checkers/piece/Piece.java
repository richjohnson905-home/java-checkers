package checkers.piece;

import checkers.Board;
import checkers.move.Jump;
import checkers.move.Move;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Piece {
    String color;
    String displayString;
    Coord coord;
    ArrayList<Move> moves = new ArrayList<Move>();
    ArrayList<Jump> jumps = new ArrayList<Jump>();
    int moveNumber = -1;

    public abstract void setSelected();
    public abstract void setUnselected();
    public abstract void addMove(Move m, int number);
    public abstract void addJump(Jump j, int number);
    public abstract Boolean isSelected();

    public Piece(Coord c, String color) {
        this.coord = c;
        this.color = color;
    }

    @Override
    public String toString() {
//        return displayString + moves.size() + "-" + moveNumber;
        return displayString;
    }

    public void switchPlacesWith(Piece piece) {
        coord = piece.coord;
        setUnselected();
    }

    public Boolean isEnemy(Piece p) {
        return ((p.color.equals("RED") && color.equals("BLACK")) ||
                (p.color.equals("BLACK") && color.equals("RED")));
    }

    public Boolean isEmpty() {
        return color.equals("EMPTY");
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public void clearMoves() {
        moves.clear();
    }

    public ArrayList<Jump> getJumps() {
        return jumps;
    }

    public Piece getSW(Board board) {
        int i = coord.i;
        int j = coord.j;
        if (j > 0 && (i < 8 && i > 0)) {
            return board.getPiece(i + 1, j - 1);
        }
        return new NullPiece(new Coord(i + 1, j - 1));
    }

    public Piece getSE(Board board) {
        int i = coord.i;
        int j = coord.j;
        if (j < 7 && i < 7) {
            return board.getPiece(i + 1, j + 1);
        }
        return new NullPiece(new Coord(i + 1, j + 1));
    }

    public Piece getNW(Board board) {
        int i = coord.i;
        int j = coord.j;
        if (j > 0 && i > 0) {
            return board.getPiece(i - 1, j - 1);

        }
        return new NullPiece(new Coord(i - 1, j - 1));
    }

    public Piece getNE(Board board) {
        int i = coord.i;
        int j = coord.j;
        if (j < 7 && i > 0) {
            return board.getPiece(i - 1, j + 1);

        }
        return new NullPiece(new Coord(i - 1, j + 1));
    }

    public void clear() {
        moves.clear();
        jumps.clear();
        moveNumber = -1;
    }

    public Coord getCoord() {
        return coord;
    }

    // TEST
    public String testGetDisplayString() {
        return displayString;
    }
}
