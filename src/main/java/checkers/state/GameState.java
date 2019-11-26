package checkers.state;

import checkers.Board;
import checkers.player.Player;

public abstract class GameState {
    Player player;

    GameState(Player player) {
        this.player = player;
    }

    public abstract Player doPlay(Board board);
}
