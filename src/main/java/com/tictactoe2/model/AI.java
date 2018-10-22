package com.tictactoe2.model;

import java.util.ArrayList;

public abstract class AI {
  public abstract int[] getMove(GameBoard gameBoard, int turns);

  protected static ArrayList<Integer> getEmptyCells(GameBoard gameBoard) {
    int size = gameBoard.getSize();
    ArrayList<Integer> emptyCells = new ArrayList<>(size);

    for (int i = 0; i < size; i++) {
      if (gameBoard.getCell(i / size, i % size) == CellState.BLANK) {
        emptyCells.add(i);
      }
    }

    return emptyCells;
  }
}
