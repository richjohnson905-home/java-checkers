package checkers.piece;

import checkers.move.Jump;
import checkers.move.Move;

public class RedPiece extends Piece {

    public RedPiece(Coord c) {
        super(c, "RED");
        displayString = " RED ";
    }

    @Override
    public Boolean isSelected() {
        return displayString == " R*D ";
    }

    @Override
    public void setSelected() {
        displayString = " R*D ";
    }

    @Override
    public void setUnselected() {
        displayString = " RED ";
    }

    @Override
    public void addMove(Move m, int number) {
        displayString = " RE " + number;
        moveNumber = number;
        moves.add(m);
    }

    @Override
    public void addJump(Jump j, int number) {
        displayString = " RE " + number;
        moveNumber = number;
        jumps.add(j);
    }

}
