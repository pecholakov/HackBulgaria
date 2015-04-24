package com.hackbulgaria.javacore.game2048;

/**
 *
 * @author Pete
 */
public enum Command {

    MOVE_UP(16), MOVE_DOWN(14), MOVE_LEFT(2), MOVE_RIGHT(6),
    NEW_GAME(110), UNDO(117), REDO(114), QUIT(113);

    private final int keyNumber;

    private Command(int keyNumber) {
        this.keyNumber = keyNumber;
    }

    public int getKeyNumber() {
        return keyNumber;
    }
}
