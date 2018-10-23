package com.tictactoe2.exception;

public class InputOutOfBoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public InputOutOfBoundException(final String msg) {
        super(msg);
    }
}