package com.hackbulgaria.javacore.game2048;

import java.io.IOException;
import java.util.Scanner;
import jline.ConsoleReader;

/**
 *
 * @author Pete
 */
public class CLI {

    private final Controller controller = new Controller();

    public void visualize() throws IOException {
        ConsoleReader reader = new ConsoleReader();
//        Scanner scan = new Scanner(System.in);
        int key;
        printBoard();
        while (true) {
            if (controller.getGame().isWinning()) {
                System.out.println("You win!");
                break;
            } else if (!controller.getGame().hasPossibleMoves()) {
                System.out.println("Game Over!");
                break;
            } else {
                key = reader.readVirtualKey();
//                System.out.println("Make move====");
//                key = scan.nextInt();
                controller.onPressedKey(key);
                reader.clearScreen();
                printBoard();
            }
        }
    }

    private void printBoard() {
        GameCore game = controller.getGame();
        Board board = game.getBoard();

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                System.out.printf("%5d ", board.getBoard()[i][j]);
            }
            System.out.println("");
        }
        System.out.printf("%nScore: %d%n", game.getScore());
    }
}
