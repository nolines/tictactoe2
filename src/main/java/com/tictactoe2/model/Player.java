package com.tictactoe2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Player {
  private int id;
  private String name;
  private String mark;

  public abstract Command makeMovement(GameBoard gameBoard);
}
