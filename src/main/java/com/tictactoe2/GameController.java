package com.tictactoe2;

import com.tictactoe2.model.Command;
import com.tictactoe2.model.GameBoard;
import com.tictactoe2.model.Player;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class GameController {
  private static final Scanner scanner = new Scanner(in);
  private int boardSize;
  private List<Player> players;
  private GameBoard gameBoard;

  public GameController(int boardSize, List<Player> players) {
    this.boardSize = boardSize;
    this.players = players;

    gameBoard = new GameBoard(boardSize);
  }

  public void start() {
    String playAgain;
    Player currentPlayer = null;
    gameBoard.clearBoard();

    do {
      boolean winner = false;

      for (int turns = 0; turns < boardSize * boardSize && !winner; turns++) {
        currentPlayer = players.get(turns % players.size());
        Command cmd = currentPlayer.makeMovement(gameBoard);
        gameBoard.applyCommand(cmd);

        // For 3 player its unnecessary to check winner every turn.
        if (turns >= players.size() * (boardSize - 1)) {
          winner = gameBoard.verifyWinner(currentPlayer);
        }
      }

      if (winner) {
        gameBoard.display();
        out.println("Player " + currentPlayer.getName() + " won!!");
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
}
