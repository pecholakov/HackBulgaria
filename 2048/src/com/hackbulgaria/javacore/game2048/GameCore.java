package com.hackbulgaria.javacore.game2048;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author Pete
 */
public class GameCore {

    private int biggestReachedTile = 0;
    private int score = 0;
    private Board board;
    private Stack<Board> redoLog;
    private Stack<Board> undoLog;

    public GameCore() {
        board = new Board();
        redoLog = new Stack<Board>();
        undoLog = new Stack<Board>();
        addNumber();
        addNumber();
        undoLog.push(board.clone());
    }

    private void setBoard(Board b) {
        this.board = b;
        undoLog.pop();
        undoLog.push(b.clone());
    }

    public Board getBoard() {
        return board;
    }

    public int getScore() {
        return score;
    }

    public boolean isWinning() {
        return biggestReachedTile == 2048;
    }

    public boolean hasPossibleMoves() {
        if (!board.hasEmptyPlaces()) {
            for (int x = 0; x < board.getSize(); x++) {
                for (int y = 0; y < board.getSize() - 1; y++) {
                    if (board.getTileValue(x, y) == board.getTileValue(x, y + 1)) {
                        return true;
                    }
                }
            }

            for (int y = 0; y < board.getSize(); y++) {
                for (int x = 0; x < board.getSize() - 1; x++) {
                    if (board.getTileValue(x, y) == board.getTileValue(x + 1, y)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public void makeMove(Command command) {
        if (command == Command.MOVE_UP) {
            moveUp();
        } else if (command == Command.MOVE_DOWN) {
            moveDown();
        } else if (command == Command.MOVE_LEFT) {
            moveLeft();
        } else if (command == Command.MOVE_RIGHT) {
            moveRight();
        }

        if (!undoLog.empty()) {
            if (!board.equals(undoLog.peek())) {
                addNumber();
                undoLog.push(board.clone());
            }
        } else {
            addNumber();
        }
        redoLog.clear();
    }

    public void undo() {
        if (undoLog.size() >= 2) {
            redoLog.push(undoLog.pop());
            board = undoLog.peek().clone();
        }
    }

    public void redo() {
        if (!redoLog.isEmpty()) {
            board = redoLog.pop();
            undoLog.push(board.clone());
        }
    }

    private void moveUp() {
        List<Integer> column = new LinkedList<>();
        Queue<Integer> slided = new LinkedList<>();

        for (int y = 0; y < board.getSize(); y++) {
            for (int x = 0; x < board.getSize(); x++) {
                if (board.getTileValue(x, y) != 0) {
                    column.add(board.getTileValue(x, y));
                }
            }
            slideTiles(column, slided);
            for (int x = 0; x < board.getSize(); x++) {
                if (!slided.isEmpty()) {
                    board.setNumber(x, y, slided.poll());
                } else {
                    board.setNumber(x, y, 0);
                }
            }
        }
    }

    private void moveDown() {
        List<Integer> column = new LinkedList<>();
        Queue<Integer> slided = new LinkedList<>();

        for (int y = 0; y < board.getSize(); y++) {
            for (int x = board.getSize() - 1; x >= 0; x--) {
                if (board.getTileValue(x, y) != 0) {
                    column.add(board.getTileValue(x, y));
                }
            }
            slideTiles(column, slided);
            for (int x = board.getSize() - 1; x >= 0; x--) {
                if (!slided.isEmpty()) {
                    board.setNumber(x, y, slided.poll());
                } else {
                    board.setNumber(x, y, 0);
                }
            }
        }
    }

    private void moveLeft() {
        List<Integer> row = new LinkedList<>();
        Queue<Integer> slided = new LinkedList<>();

        for (int x = 0; x < board.getSize(); x++) {
            for (int y = 0; y < board.getSize(); y++) {
                if (board.getTileValue(x, y) != 0) {
                    row.add(board.getTileValue(x, y));
                }
            }
            slideTiles(row, slided);
            for (int y = 0; y < board.getSize(); y++) {
                if (!slided.isEmpty()) {
                    board.setNumber(x, y, slided.poll());
                } else {
                    board.setNumber(x, y, 0);
                }
            }
        }
    }

    private void moveRight() {
        List<Integer> row = new LinkedList<>();
        Queue<Integer> slided = new LinkedList<>();

        for (int x = 0; x < board.getSize(); x++) {
            for (int y = board.getSize() - 1; y >= 0; y--) {
                if (board.getTileValue(x, y) != 0) {
                    row.add(board.getTileValue(x, y));
                }
            }
            slideTiles(row, slided);
            for (int y = board.getSize() - 1; y >= 0; y--) {
                if (!slided.isEmpty()) {
                    board.setNumber(x, y, slided.poll());
                } else {
                    board.setNumber(x, y, 0);
                }
            }
        }
    }

    private void slideTiles(List<Integer> given, Queue<Integer> slided) {
        for (int i = 0; i < given.size(); i++) {
            if (i < given.size() - 1 && given.get(i).equals(given.get(i + 1))) {
                int mergedTile = given.get(i) * 2;
                slided.add(mergedTile);
                given.remove(i + 1);
                given.add(0);
                if (mergedTile > biggestReachedTile) {
                    biggestReachedTile = mergedTile;
                }
                score += mergedTile;
            } else {
                slided.add(given.get(i));
            }
        }
        given.clear();
    }

    private void addNumber() {
        Random rand = new Random();
        List<Integer[]> coordinates = board.getEmptyPlacesCoordinates();
        if (!coordinates.isEmpty()) {
            int randomNumber = rand.nextInt(99);
            int numberToPlace = (randomNumber < 90) ? 2 : 4;
            randomNumber = rand.nextInt(coordinates.size());
            Integer[] generatedCoordinate = coordinates.get(randomNumber);
            board.setNumber(generatedCoordinate[0], generatedCoordinate[1], numberToPlace);
        }
    }

    public void quit() {
        System.exit(0);
    }

//    public static void main(String[] args) {
//        int[][] m = new int[][]{
//            {0, 0, 0, 0},
//            {0, 0, 2, 0},
//            {0, 2, 0, 0},
//            {0, 0, 0, 0}
//        };
//        Board b = new Board(m);
//        GameCore engine = new GameCore();
//        engine.setBoard(b);
//
//    }
}
