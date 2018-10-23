package com.tictactoe2;

import com.tictactoe2.model.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.tictactoe2.util.util.BOARD_SIZE;
import static com.tictactoe2.util.util.CURRENT_PLAYER_ID;

public class GameTest {

  private Game underTest;

  @Before
  public void setup() {

    List<Player> playerList = new ArrayList<>();
    playerList.add(new Player(1, "Test-User", "X"));

    this.underTest = new Game(BOARD_SIZE, CURRENT_PLAYER_ID, playerList);
  }

}
