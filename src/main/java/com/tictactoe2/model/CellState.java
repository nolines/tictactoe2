package com.tictactoe2.model;

public enum CellState {
  BLANK("BLANK", 0),
  X("X", 1),
  Y("Y", 2),
  O("O", 3);

  private final String key;
  private final Integer value;

  CellState(String key, Integer value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public Integer getValue() {
    return value;
  }

  @Override
  public String toString() {
    if (this.name().equals("BLANK")) {
      return " ";
    } else {
      return this.name();
    }
  }
}
