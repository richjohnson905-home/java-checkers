package checkers.state;

import checkers.Board;
import checkers.player.Player;

public class FindMovesState extends GameState {

    public FindMovesState(Player player) {
        super(player);
    }

    @Override
    public Player doPlay(Board board) {
        System.out.println("FIND MOVES STATE");
        player.clearMoves();
        if (!player.findJumps()) {
            player.findMoves();
            player.changeState(new FromMoveState(player));
        } else {
            player.changeState(new FromJumpState(player));
        }

        return player;
    }

}
