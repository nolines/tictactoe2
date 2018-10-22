package com.tictactoe2;

import com.tictactoe2.config.FileConfig;
import com.tictactoe2.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    // SETTING UP GAME
    AI computer = null;
    computer = new AIPlayer();

    FileConfig fileConfig = new FileConfig();
    List<Setting> settings = fileConfig.readFromFile();

    int size =
        Integer.parseInt(
            settings
                .stream()
                .filter(item -> item.getKey().equals("battlefieldSize"))
                .collect(Collectors.toList())
                .get(0)
                .getValue());

    GameBoard gameBoard = new GameBoard();
    gameBoard.setSize(size);
    gameBoard.setSquares(new CellState[size][size]);

    List<Player> players = new ArrayList<>();
    players.add(new Player(1, "Player1", "X"));
    players.add(new Player(2, "Player2", "Y"));
    players.add(new Player(3, "AI", "O"));

    // GAME STARTS
    Game game = new Game(size, players.get(0).getId(), players);
    game.start(gameBoard, computer);
  }
}