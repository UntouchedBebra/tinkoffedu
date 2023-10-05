package edu.hw1;

public class Task8 {
    private final int[][] chessBoard;
    private final static int CHESSBOARD_LOWER_BOUNDARY_INDEX = 0;
    private final static int CHESSBOARD_DIMENSION_INDEX = 7;
    private final static int KNIGHT = 1;

    private final static int[][] KNIGHT_MOVES = {
        {-2, -1}, {-2, 1},
        {-1, -2}, {-1, 2},
        {1, -2}, {1, 2},
        {2, -1}, {2, 1}
    };

    public Task8(int[][] playField) {
        this.chessBoard = playField;
    }

    private boolean deskNotNull() {
        return chessBoard != null;
    }

    private boolean deskCapacityIsEight() {
        return chessBoard.length == 8;
    }

    private boolean subArraysNotNull() {
        for (int[] line : chessBoard) {
            if (line == null) {
                return false;
            }
        }
        return true;
    }

    private boolean subArraysCapacitiesAreEight() {
        for (int[] line : chessBoard) {
            if (line.length != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean usedOnlyZerosAndOnes() {
        for (int[] line : chessBoard) {
            for (int elem : line) {
                if (Math.abs(elem) > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean deskProcessing() {
        if (deskNotNull()
            && deskCapacityIsEight()
            && subArraysNotNull()
            && subArraysCapacitiesAreEight()
            && usedOnlyZerosAndOnes()) {
            for (int i = 0; i < CHESSBOARD_DIMENSION_INDEX; i++) {
                for (int j = 0; j < CHESSBOARD_DIMENSION_INDEX; j++) {
                    if (chessBoard[i][j] == KNIGHT) {
                        if (knightsAround(i, j)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean knightsAround(int row, int column) {

        for (int[] move : KNIGHT_MOVES) {
            int enemyRow = row + move[0];
            int enemyColumn = column + move[1];
            if (figureIsInsideTheBoard(enemyRow, enemyColumn)
                && chessBoard[enemyRow][enemyColumn] == KNIGHT) {
                return true;
            }
        }
        return false;
    }

    private boolean figureIsInsideTheBoard(int enemyRow, int enemyColumn) {
        return enemyRow >= CHESSBOARD_LOWER_BOUNDARY_INDEX
               && enemyRow <= CHESSBOARD_DIMENSION_INDEX
               && enemyColumn >= CHESSBOARD_LOWER_BOUNDARY_INDEX
               && enemyColumn <= CHESSBOARD_DIMENSION_INDEX;
    }
}
