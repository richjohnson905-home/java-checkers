package checkers.piece;

import checkers.move.Jump;
import checkers.move.Move;

public class NullPiece extends Piece {
    public NullPiece(Coord c) {

        super(c, " NULL");
        displayString = "     ";
    }

    @Override
    public Boolean isSelected() {
        return false;
    }

    @Override
    public void setSelected() {

    }

    @Override
    public void setUnselected() {

    }

    @Override
    public void addMove(Move m, int number) {

    }

    @Override
    public void addJump(Jump j, int number) {

    }

}
