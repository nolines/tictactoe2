package com.tictactoe2.model;

import org.junit.Before;

import static com.tictactoe2.util.util.initBoard;

public class PlayerTest {

  private GameBoard gameBoard;
  private Player underTest;

  @Before
  public void setup() {
    gameBoard = initBoard();
  }

  //  @Test
  //  public void shouldMakeMovementWithHumanPlayer() {
  //    underTest = new HumanPlayer(1, "TESTUSER", "X");
  //
  //    String input = "0 2";
  //    InputStream in = new ByteArrayInputStream(input.getBytes());
  //    System.setIn(in);
  //
  //    Command expectedCmd = underTest.makeMovement(gameBoard);
  //    Assert.assertEquals(expectedCmd.getMark(), "X");
  //    Assert.assertEquals(expectedCmd.getX(), 0);
  //    Assert.assertEquals(expectedCmd.getY(), 2);
  //  }
}
