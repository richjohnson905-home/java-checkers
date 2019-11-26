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
        player.clearMoves(player.getPieces());
        if (!player.findJumps()) {
            player.findMoves();
        }
        player.changeState(new FromState(player));
        return player;
    }

}
