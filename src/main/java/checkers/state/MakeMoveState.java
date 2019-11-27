package checkers.state;

import checkers.Board;
import checkers.piece.Coord;
import checkers.piece.EmptyPiece;
import checkers.player.Player;

import java.util.Scanner;

public class MakeMoveState extends GameState {

    MakeMoveState(Player player) {
        super(player);
    }

    @Override
    public Player doPlay(Board board) {

        System.out.println("MOVE STATE TIME");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Make Move? 1=yes");
        String choice = myObj.nextLine();

        player.getTheMove().doMove(board);
        player.getNextPlayer().changeState(new FindMovesState(player.getNextPlayer()));
        return player.getNextPlayer();
    }

}
