package checkers.state;

import checkers.Board;
import checkers.player.Player;

import java.util.Scanner;

public class ToJumpState extends GameState {

    public ToJumpState(Player player) {
        super(player);
    }

    @Override
    public Player doPlay(Board board) {

        System.out.println("TO JUMP STATE");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Select to-jump number");
        String choice = myObj.nextLine();
        try {
            int number = Integer.parseInt(choice);
            player.setJumpToNumber(number);
            player.changeState(new MakeJumpState(player));

        } catch (NumberFormatException e) {
            System.out.println("Number format exception");
        }
        return player;
    }

}
