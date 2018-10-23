package com.tictactoe2.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.tictactoe2.util.util.BOARD_SIZE;

public class GameBoardTest {

  private GameBoard underTest;

  @Before
  public void setup() {
    GameBoard gameBoard = new GameBoard();
    gameBoard.setSize(BOARD_SIZE);
    gameBoard.setSquares(new Cell[BOARD_SIZE][BOARD_SIZE]);

    underTest = gameBoard;
  }

  @Test
  public void shouldClearBoard() {
    underTest.clearBoard();

    Assert.assertEquals(underTest.getCell(0, 0), Cell.BLANK);
  }

  @Test
  public void shouldGetValueOfCell() {
    Assert.assertEquals(underTest.getCell(0, 0), null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionWhenCellLengthLesserThan2() {
    underTest.getCell(new int[] {0});
  }

  @Test
  public void shouldReturnCellMovementWhenCallsWithCellNumber() {
    int[] expected = underTest.intToCell(2);

    Cell[][] squares = underTest.getSquares();
    squares[expected[0]][expected[1]] = Cell.X;

    Assert.assertEquals(underTest.getCell(0, 2).getKey(), Cell.X.getKey());
  }

  @Test
  public void shouldReturnWinnerWhenVerifyWithAllXsInFirstRow() {

    for (int i = 0; i < BOARD_SIZE; i++) {
      int[] expected = underTest.intToCell(i);
      Cell[][] squares = underTest.getSquares();
      squares[expected[0]][expected[1]] = Cell.X;
    }

    Player player = new Player(1, "Test-User", "X");
    boolean expected = underTest.verifyWinner(player);

    Assert.assertTrue(expected);
  }
}
