package com.tictactoe2.model;

import com.tictactoe2.exception.EmptyCellException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIPlayer extends Player {
  Random generator;

  public AIPlayer(int id, String name, String mark) {
    super(id, name, mark);
    this.generator = new Random();
  }

  @Override
  public Command makeMovement(GameBoard gameBoard) throws EmptyCellException {

    List<String> emptyCells = new ArrayList<>();

    for (int i = 0; i < gameBoard.getSize(); i++) {
      for (int j = 0; j < gameBoard.getSize(); j++) {
        if (gameBoard.getCell(i, j).equals(" ")) {
          emptyCells.add(i + "," + j);
        }
      }
    }

    if (emptyCells.isEmpty()) {
      throw new EmptyCellException("There is no empty cell");
    }

    String emptyCell = emptyCells.get(generator.nextInt(emptyCells.size()));
    int x = Integer.parseInt(emptyCell.split(",")[0]);
    int y = Integer.parseInt(emptyCell.split(",")[1]);

    return new Command(x, y, this.getMark());
  }
}
