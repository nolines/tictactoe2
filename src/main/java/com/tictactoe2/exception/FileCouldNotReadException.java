package com.tictactoe2.exception;

public class FileCouldNotReadException extends Throwable {
  private static final long serialVersionUID = 1L;

  public FileCouldNotReadException(final String msg) {
    super(msg);
  }
}
