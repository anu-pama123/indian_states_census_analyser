package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String INDIA_CENSUS_WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String INDIA_CENSUS_WRONG_FILE_TYPE = "./src/main/resources/IndiaStateCensusData.jpg";
    private static final String INDIA_STATE_CODE_CSV_FILE_PATH = "./src/test/resources/IndiaStateCode.csv";
    private static final String INDIA_STATE_CODE_WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCode.csv";
    private static final String INDIA_STATE_CODE_WRONG_FILE_TYPE = "./src/main/resources/IndiaStateCode.jpg";

    @Test
    public void givenIndianCensusCsvFile_WhenCorrect_ShouldReturnRecordCount() throws CensusAnalyserException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int numOfRecords = censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH);
        Assert.assertEquals(29,numOfRecords);
    }

    @Test
    public void givenIndianCensusCsvFile_WhenIncorrect_ThenThrowsCensusAnalyzerException() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            censusAnalyser.loadCensusData(INDIA_CENSUS_WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenCsvFile_WhenTypeIncorrect_ThenThrowsCensusAnalyzerException() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            censusAnalyser.loadCensusData(INDIA_CENSUS_WRONG_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenCsvFile_WhenDelimiterIncorrect_ThrowsException() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER_OR_HEADER, e.type);
        }
    }

    @Test
    public void givenCsvFile_WhenHeaderIncorrect_ThrowsException() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER_OR_HEADER, e.type);
        }
    }

    @Test
    public void givenStateCodeCSVFile_WhenCountsRecord_ShouldReturnRecordCount() throws CensusAnalyserException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int numOfRecords = censusAnalyser.loadStateCodeData(INDIA_STATE_CODE_CSV_FILE_PATH);
        Assert.assertEquals(37, numOfRecords);
    }

    @Test
    public void givenStateCodeCsvFile_WhenIncorrect_ThenThrowsCensusAnalyzerException() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            censusAnalyser.loadStateCodeData(INDIA_STATE_CODE_WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenStateCodeCsvFile_WhenTypeIncorrect_ThenThrowsCensusAnalyzerException() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            censusAnalyser.loadStateCodeData(INDIA_STATE_CODE_WRONG_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenStateCodeCsvFile_WhenDelimiterIncorrect_ThrowsException() throws CensusAnalyserException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            censusAnalyser.loadStateCodeData(INDIA_STATE_CODE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_DELIMITER_OR_HEADER, e.type);
        }
        catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.WRONG_DELIMITER_OR_HEADER);
        }
    }
}
