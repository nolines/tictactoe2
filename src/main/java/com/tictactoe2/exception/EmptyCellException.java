package com.tictactoe2.exception;

public class EmptyCellException extends Exception {
    private static final long serialVersionUID = 1L;

    public EmptyCellException(final String msg) {
        super(msg);
    }
}