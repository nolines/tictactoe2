package com.tictactoe2;

import com.tictactoe2.model.AI;
import com.tictactoe2.model.CellState;
import com.tictactoe2.model.GameBoard;
import com.tictactoe2.model.Player;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.in;
import static java.lang.System.out;

public class Game {
  private static final Scanner scanner = new Scanner(in);
  private int boardSize;
  private int currentPlayerId;
  private List<Player> players;

  public Game(int boardSize, int currentPlayerId, List<Player> players) {
    this.boardSize = boardSize;
    this.currentPlayerId = currentPlayerId;
    this.players = players;
  }

  public void start(GameBoard gameBoard, AI computer) {
    String playAgain;

    gameBoard.clearBoard();
    boolean playComputer = true;

    do {
      int[] move;
      boolean winner = false;

      for (int turns = 1; turns < boardSize * boardSize && !winner; turns++) {
        if (turns % 3 == 0 && currentPlayerId == 0) {
          move = computer.getMove(gameBoard, turns);
        } else {
          move = promptMove(gameBoard);
        }

        if (null == move) {
          out.println("Exit");
        } else {
          gameBoard.setMove(move, currentPlayerId);
          displayBoard(gameBoard);

          // For 3 player its unnecessary to check winner every turn.
          if (turns > 6) {
            winner = gameBoard.verifyWinner(getCurrentPlayer());
          }

          nextPlayerMove();
        }
      }

      if (winner) {
        displayBoard(gameBoard);
        out.println("Player" + (currentPlayerId - 1) + " won!!");
      } else {
        out.println("It was a tie.");
      }

      out.print("Play again [y/N]? ");
      playAgain = scanner.nextLine();
      if (playAgain.equalsIgnoreCase("y") || playAgain.equalsIgnoreCase("yes")) {
        gameBoard.clearBoard();
      }
    } while (playAgain.equalsIgnoreCase("y") || playAgain.equalsIgnoreCase("yes"));
  }

  private void nextPlayerMove() {
    currentPlayerId = currentPlayerId < 2 ? currentPlayerId + 1 : 0;
  }

  private int[] promptMove(GameBoard gameBoard) {
    int[] cell = {0, 0};
    boolean validTurn = false;
    do {
      out.print("Player" + currentPlayerId + " enter your coordinates (row column): ");
      String[] input = scanner.nextLine().split(" ");
      cell[0] = Integer.parseInt(input[0]) - 1;
      cell[1] = Integer.parseInt(input[1]) - 1;

      if (cell[0] < 0 || cell[0] > boardSize || cell[1] < 0 || cell[1] > boardSize) {
        out.println("That cell doesn't exist!");
      } else if (gameBoard.getCell(cell[0], cell[1]) != CellState.BLANK) {
        out.println("That cell has already been played!");
      } else {
        validTurn = true;
      }
    } while (!validTurn);
    return cell;
  }

  private void displayBoard(GameBoard gameBoard) {
    String b = "\n";
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        b += "|" + gameBoard.getSquares()[i][j];

        if (j == boardSize - 1) {
          b += "|\n";
        }
      }
    }

    out.println(b);
  }

  private Player getCurrentPlayer() {
    return this.players
        .stream()
        .filter(player -> player.getId() == currentPlayerId)
        .collect(Collectors.toList())
        .get(0);
  }
}