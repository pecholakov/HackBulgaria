package com.hackbulgaria.javacore.game2048;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Pete
 */
public class Board {

    private final int BOARD_SIZE = 4;
    private int[][] board;

    public Board() {
        board = new int[BOARD_SIZE][BOARD_SIZE];
    }

    public Board(int[][] rhs) {
        board = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = Arrays.copyOf(rhs[i], BOARD_SIZE);
        }
    }

    public int getSize() {
        return BOARD_SIZE;
    }

    public void setNumber(int x, int y, int number) {
        if (x < BOARD_SIZE && y < BOARD_SIZE) {
            board[x][y] = number;
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public int getTileValue(int x, int y) {
        return board[x][y];
    }

    public List<Integer[]> getEmptyPlacesCoordinates() {
        ArrayList<Integer[]> coordinates = new ArrayList<>();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 0) {
                    coordinates.add(new Integer[]{i, j});
                }
            }
        }
        return coordinates;
    }

    public boolean hasEmptyPlaces() {
        return !getEmptyPlacesCoordinates().isEmpty();
    }

    @Override
    public Board clone() {
        Board newBoard = new Board();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                newBoard.setNumber(i, j, board[i][j]);
            }
        }
        return newBoard;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.BOARD_SIZE;
        hash = 59 * hash + Arrays.deepHashCode(this.board);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Board other = (Board) obj;
        if (this.BOARD_SIZE != other.BOARD_SIZE) {
            return false;
        }
        return Arrays.deepEquals(this.board, other.board);
    }

}
