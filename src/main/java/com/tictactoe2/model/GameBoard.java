package com.tictactoe2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameBoard {
  private Cell[][] squares;
  private int size;

  public final void clearBoard() {
    for (Cell[] row : squares) {
      Arrays.fill(row, Cell.BLANK);
    }
  }

  public Cell getCell(int column, int row) {
    return squares[column][row];
  }

  public Cell getCell(int[] cell) {
    if (cell.length != 2) {
      throw new IllegalArgumentException("Cells must have columns and rows.");
    }

    return getCell(cell[0], cell[1]);
  }

  public int[] intToCell(int cellNumber) {
    int cell[] = {cellNumber / size, cellNumber % size};
    return cell;
  }

  public void setMove(int[] move, int currentPlayerId) {
    switch (currentPlayerId) {
      case 1:
        squares[move[0]][move[1]] = Cell.X;
        break;
      case 2:
        squares[move[0]][move[1]] = Cell.Y;
        break;
      case 3:
        squares[move[0]][move[1]] = Cell.O;
        break;

      default:
    }
  }

  public boolean verifyWinner(Player currentPlayer) {

    int count;

    for (int x = 0; x < size; x++) {
      count = 0;

      for (int y = 0; y < size; y++) {
        if (this.getCell(x, y).getKey().equals(currentPlayer.getMark())) {
          count++;
        }
      }
      if (count == size) return true;
    }

    for (int y = 0; y < size; y++) {
      count = 0;
      for (int x = 0; x < size; x++) {
        if (this.getCell(x, y).getKey().equals(currentPlayer.getMark())) {
          count++;
        }
      }
      if (count == size) return true;
    }

    count = 0;
    for (int x = 0; x < size; x++) {
      if (this.getCell(x, x).getKey().equals(currentPlayer.getMark())) {
        count++;
      }
    }
    if (count == size) return true;
    count = 0;
    int y = size - 1;
    for (int x = 0; x < size; x++) {
      if (this.getCell(x, y - x).getKey().equals(currentPlayer.getMark())) {
        count++;
      }
    }
    if (count == size) return true;

    count = 0;
    for (int x = 0; x < size; x++) {
      for (y = 0; y < size; y++) {
        if (!this.getCell(x, y).getKey().equals(Cell.BLANK.getKey())) count++;
      }
    }

    if (count == size * size) {
      System.out.println(String.format("\nThere are no winners, the game ended in a draw. :/\n"));
      System.exit(0);
      return false;
    }

    return false;
  }
}
