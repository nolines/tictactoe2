package com.tictactoe2.model;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class HumanPlayer extends Player {
  private static final Scanner scanner = new Scanner(in);

  public HumanPlayer(int id, String name, String mark) {
    super(id, name, mark);
  }

  @Override
  public Command makeMovement(GameBoard gameBoard) {
    boolean validTurn = false;
    int x, y;

    do {
      out.print("Player" + this.getId() + " enter your coordinates (row column): ");
      String[] input = scanner.nextLine().split(" ");
      x = Integer.parseInt(input[0]) - 1;
      y = Integer.parseInt(input[1]) - 1;

      if (x < 0 || x > gameBoard.getSize() || y < 0 || y > gameBoard.getSize()) {
        out.println("That cell doesn't exist!");
      } else if (!gameBoard.getCell(x, y).equals(" ")) {
        out.println("That cell has already been played!");
      } else {
        validTurn = true;
      }
    } while (!validTurn);
    return new Command(x, y, this.getMark());
  }
}
