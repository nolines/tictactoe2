package com.tictactoe2.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

import static java.lang.System.out;

@Getter
@Setter
public class GameBoard {
  private String[][] squares;
  private int size;

  public GameBoard(int size) {
    this.size = size;
    squares = new String[size][size];
  }

  public final void clearBoard() {
    for (String[] row : squares) {
      Arrays.fill(row, " ");
    }
  }

  public String getCell(int column, int row) {
    return squares[column][row];
  }

  public void applyCommand(Command command) {
    squares[command.getX()][command.getY()] = command.getMark();
    display();
  }

  public boolean verifyWinner(Player currentPlayer) {

    int count;

    for (int x = 0; x < size; x++) {
      count = 0;

      for (int y = 0; y < size; y++) {
        if (this.getCell(x, y).equals(currentPlayer.getMark())) {
          count++;
        }
      }
      if (count == size) return true;
    }

    for (int y = 0; y < size; y++) {
      count = 0;
      for (int x = 0; x < size; x++) {
        if (this.getCell(x, y).equals(currentPlayer.getMark())) {
          count++;
        }
      }
      if (count == size) return true;
    }

    count = 0;
    for (int x = 0; x < size; x++) {
      if (this.getCell(x, x).equals(currentPlayer.getMark())) {
        count++;
      }
    }
    if (count == size) return true;
    count = 0;
    int y = size - 1;
    for (int x = 0; x < size; x++) {
      if (this.getCell(x, y - x).equals(currentPlayer.getMark())) {
        count++;
      }
    }
    if (count == size) return true;

    count = 0;
    for (int x = 0; x < size; x++) {
      for (y = 0; y < size; y++) {
        if (!this.getCell(x, y).equals(" ")) count++;
      }
    }

    if (count == size * size) {
      System.out.println(String.format("\nThere are no winners, the game ended in a draw. :/\n"));
      System.exit(0);
      return false;
    }

    return false;
  }

  public void display() {
    String b = "\n";
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        b += "|" + this.getSquares()[i][j];

        if (j == size - 1) {
          b += "|\n";
        }
      }
    }

    out.println(b);
  }
}
