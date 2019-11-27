package checkers.state;

import checkers.Board;
import checkers.player.Player;

import java.util.Scanner;

public class ToMoveState extends GameState {

    public ToMoveState(Player player) {
        super(player);
    }

    @Override
    public Player doPlay(Board board) {

        System.out.println("TO STATE");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Select to-move number");
        String choice = myObj.nextLine();
        try {
            int number = Integer.parseInt(choice);
            player.setMoveToNumber(number);
            player.changeState(new MakeMoveState(player));

        } catch (NumberFormatException e) {
            System.out.println("Number format exception");
        }
        return player;
    }

}
