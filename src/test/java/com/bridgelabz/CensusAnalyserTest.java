package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String INDIA_CENSUS_WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String INDIA_CENSUS_WRONG_FILE_TYPE = "./src/main/resources/IndiaStateCensusData.jpg";

    @Test
    public void givenIndianCensusCsvFile_WhenCorrect_ShouldReturnRecordCount() throws CensusAnalyzerException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int numOfRecords = censusAnalyser.recordsCounter(INDIA_CENSUS_CSV_FILE_PATH);
        Assert.assertEquals(29,numOfRecords);
    }

    @Test
    public void givenIndianCensusCsvFile_WhenIncorrect_ThenThrowsCensusAnalyzerException() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            censusAnalyser.recordsCounter(INDIA_CENSUS_WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenCsvFile_WhenTypeIncorrect_ThenThrowsCensusAnalyzerException() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            censusAnalyser.recordsCounter(INDIA_CENSUS_WRONG_FILE_TYPE);
        } catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenCsvFile_WhenDelimiterIncorrect_ThrowsException() throws CensusAnalyzerException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            censusAnalyser.recordsCounter(INDIA_CENSUS_CSV_FILE_PATH);
        } catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.WRONG_DELIMITER_OR_HEADER, e.type);
        }
        catch (RuntimeException e) {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.WRONG_DELIMITER_OR_HEADER);
        }
    }
}
