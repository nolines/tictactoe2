package com.tictactoe2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Command {
  private int x;
  private int y;
  private String mark;
}
