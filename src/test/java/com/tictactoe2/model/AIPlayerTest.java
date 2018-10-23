package com.tictactoe2.model;

import com.tictactoe2.exception.EmptyCellException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.Random;

import static com.tictactoe2.util.util.initBoard;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AIPlayerTest {
  private GameBoard gameBoard;
  @InjectMocks private AIPlayer underTest;

  @Before
  public void setUp() {
    Random generatorMock = mock(Random.class);
    when(generatorMock.nextInt()).thenReturn(0);

    gameBoard = initBoard();
    underTest = new AIPlayer(3, "TESTAIPLAYER", "O");
  }

  @Test
  public void shouldMakeMovementWithAIPlayer() throws EmptyCellException {
    gameBoard.applyCommand(new Command(0, 1, " "));
    gameBoard.applyCommand(new Command(0, 2, " "));
    gameBoard.applyCommand(new Command(2, 1, " "));
    gameBoard.applyCommand(new Command(2, 1, " "));

    Command expectedCmd = underTest.makeMovement(gameBoard);

    Assert.assertNotEquals(expectedCmd.getMark(), " ");
  }
}
