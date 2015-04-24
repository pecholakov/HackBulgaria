package com.hackbulgaria.javacore.game2048;

/**
 *
 * @author Pete
 */
public class Controller {

    private GameCore game;

    public Controller() {
        game = new GameCore();
    }

    public GameCore getGame() {
        return game;
    }

    public void onPressedKey(int key) {
        if (key == Command.MOVE_UP.getKeyNumber()) {
            game.makeMove(Command.MOVE_UP);
        } else if (key == Command.MOVE_DOWN.getKeyNumber()) {
            game.makeMove(Command.MOVE_DOWN);
        } else if (key == Command.MOVE_LEFT.getKeyNumber()) {
            game.makeMove(Command.MOVE_LEFT);
        } else if (key == Command.MOVE_RIGHT.getKeyNumber()) {
            game.makeMove(Command.MOVE_RIGHT);
        } else if (key == Command.NEW_GAME.getKeyNumber()) {
            game = new GameCore();
        } else if (key == Command.UNDO.getKeyNumber()) {
            game.undo();
        } else if (key == Command.REDO.getKeyNumber()) {
            game.redo();
        } else if (key == Command.QUIT.getKeyNumber()) {
            game.quit();
        }
    }
}
