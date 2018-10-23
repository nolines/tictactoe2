package com.tictactoe2;

import com.tictactoe2.config.FileConfig;
import com.tictactoe2.model.AIPlayer;
import com.tictactoe2.model.HumanPlayer;
import com.tictactoe2.model.Player;
import com.tictactoe2.model.Setting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    // SETTING UP GAME
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

    if (size < 3 || size > 10) {
      throw new NumberFormatException();
    }

    List<Player> players = new ArrayList<>();
    // User can easily change players to human or ai player to play with 2 human,1 ai or 3 human or
    // 2 ai, 1 human or all ai.
    players.add(new HumanPlayer(1, "Player1", "X"));
    players.add(new HumanPlayer(2, "Player2", "Y"));
    players.add(new AIPlayer(3, "AIPlayer", "O"));

    // GAME STARTS
    GameController game = new GameController(size, players);
    game.start();
  }
}
