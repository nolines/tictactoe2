package com.tictactoe2.model;

import org.junit.Before;

import static com.tictactoe2.util.util.BOARD_SIZE;

public class AITest {

  private AI underTest;
  private GameBoard gameBoard;

  @Before
  public void setup() {
    gameBoard = new GameBoard();
    gameBoard.setSize(BOARD_SIZE);
    gameBoard.setSquares(new Cell[BOARD_SIZE][BOARD_SIZE]);

    underTest = new AIPlayer();
  }

//  @Test
//  public void shouldGetEmptyCells() {
//    for (int i = 0; i < BOARD_SIZE; i++) {
//      int[] intCell = gameBoard.intToCell(i);
//      Cell[][] squares = gameBoard.getSquares();
//      squares[intCell[0]][intCell[0]] = Cell.X;
//      squares[intCell[0]][intCell[1]] = Cell.X;
//    }
//
//    Assert.assertEquals(underTest.getEmptyCells(gameBoard).size(), 7);
//  }
}
