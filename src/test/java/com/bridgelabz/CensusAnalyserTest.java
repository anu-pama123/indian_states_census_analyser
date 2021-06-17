package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CensusAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    @Test
    public void givenIndianCensusCsvFile_WhenCountsRecords_ShouldReturnRecordCount() throws IOException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int numOfRecords = censusAnalyser.recordsCounter(INDIA_CENSUS_CSV_FILE_PATH);
        Assert.assertEquals(29,numOfRecords);
    }
}
