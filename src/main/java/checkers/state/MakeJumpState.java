package checkers.state;

import checkers.Board;
import checkers.player.Player;

import java.util.Scanner;

public class MakeJumpState extends GameState {

    MakeJumpState(Player player) {
        super(player);
    }

    @Override
    public Player doPlay(Board board) {

        System.out.println("JUMP STATE TIME");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Make Jump? 1=yes");
        String choice = myObj.nextLine();

        player.getTheJump().doJump(board);
        player.getNextPlayer().losePieces(player.getTheJump());
        player.getNextPlayer().changeState(new FindMovesState(player.getNextPlayer()));
        return player.getNextPlayer();
    }

}
