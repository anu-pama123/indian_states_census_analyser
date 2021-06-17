package com.bridgelabz;

public class CensusAnalyzerException extends Exception {
    public enum ExceptionType {
        CENSUS_FILE_WRONG
    }

    public ExceptionType type;

    public CensusAnalyzerException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
