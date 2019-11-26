package checkers.piece;

import checkers.move.Jump;
import checkers.move.Move;

public class EmptyPiece extends Piece {

    public EmptyPiece(Coord c) {
        super(c, "EMPTY");
        displayString = " ___ ";
    }

    @Override
    public Boolean isSelected() {
        return displayString == " _*_ ";
    }

    @Override
    public void setSelected() {
        displayString = " _*_ ";
    }

    @Override
    public void setUnselected() {
        displayString = " ___ ";
    }

    @Override
    public void addMove(Move m, int number) {
        moveNumber = number;
        displayString = " _" + number + "_ ";
    }

    @Override
    public void addJump(Jump j, int number) {
        displayString = " _" + number + "_ ";
        moveNumber = number;
    }
}
