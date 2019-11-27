package checkers.state;

import checkers.Board;
import checkers.player.Player;

import java.util.Scanner;

public class FromJumpState extends GameState {

    public FromJumpState(Player player) {
        super(player);
    }

    @Override
    public Player doPlay(Board board) {

        System.out.println("FROM JUMP STATE");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Select jump-from number");
        String choice = myObj.nextLine();
        try {
            int number = Integer.parseInt(choice);
            player.setJumpFromNumber(number);
            player.changeState(new ToJumpState(player));

        } catch (NumberFormatException e) {
            System.out.println("Number format exception");
        }
        return player;
    }

}
