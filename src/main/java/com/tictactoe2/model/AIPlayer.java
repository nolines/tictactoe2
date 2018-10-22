package com.tictactoe2.model;

import java.util.ArrayList;
import java.util.Random;

public class AIPlayer extends AI {
    Random generator;

    public AIPlayer() {
        generator = new Random();
    }

    @Override
    public int[] getMove(GameBoard gameBoard, int turns) {
        ArrayList<Integer> emptyCells = getEmptyCells(gameBoard);

        int move = emptyCells.get(generator.nextInt(emptyCells.size()));
        return gameBoard.intToCell(move);
    }
}