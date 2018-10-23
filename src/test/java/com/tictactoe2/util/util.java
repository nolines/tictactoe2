package com.tictactoe2.util;

import com.tictactoe2.model.Command;
import com.tictactoe2.model.GameBoard;

public class util {
  public static final int BOARD_SIZE = 3;
  public static GameBoard gameBoard;

  public static final GameBoard initBoard() {
    gameBoard = new GameBoard(BOARD_SIZE);

    for (int i = 0; i < gameBoard.getSize(); i++) {
      for (int j = 0; j < gameBoard.getSize(); j++) {
        gameBoard.applyCommand(new Command(i, j, "X"));
      }
    }

    return gameBoard;
  }
}
