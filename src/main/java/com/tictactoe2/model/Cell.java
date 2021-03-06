package com.tictactoe2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Cell {
  private int x;
  private int y;
  private String value;
}
