package com.java.basic.advance.thread.basics.throwable;

import java.io.FileNotFoundException;

public class ErrorAndException {

    private void throwError() {
        throw new StackOverflowError();
    }

    private void throwRuntimeException() {
        throw new RuntimeException();
    }

    private void threadCheckedException() {
        try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ErrorAndException eae = new ErrorAndException();
        eae.throwError();
        eae.throwRuntimeException();
        eae.threadCheckedException();
    }
}
