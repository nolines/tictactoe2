package com.tictactoe2.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.tictactoe2.util.util.BOARD_SIZE;

public class GameBoardTest {

  private GameBoard underTest;

  @Before
  public void setup() {
    underTest = new GameBoard(BOARD_SIZE);
  }

  @Test
  public void shouldClearBoard() {
    underTest.applyCommand(new Command(2, 2, "X"));
    underTest.clearBoard();
    Assert.assertEquals(underTest.getCell(2, 2), " ");
  }

  @Test
  public void shouldGetCell() {
    underTest.applyCommand(new Command(2, 2, "X"));
    Assert.assertEquals(underTest.getCell(2, 2), "X");
  }

  @Test
  public void shouldVerifyWinner() {

    underTest.applyCommand(new Command(0, 0, "X"));
    underTest.applyCommand(new Command(0, 1, "X"));
    underTest.applyCommand(new Command(0, 2, "X"));

    Player currentPlayer = new HumanPlayer(1, "TESTUSER", "X");
    Assert.assertTrue(underTest.verifyWinner(currentPlayer));
  }
}
