package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyser {
    public int recordsCounter(String csvFilePath) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
        CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
        csvToBeanBuilder.withType(IndiaCensusCSV.class);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
        Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
        Iterable<IndiaCensusCSV> censusCSVIterable = () -> censusCSVIterator;
        int numOfEntries = (int) StreamSupport.stream(censusCSVIterable.spliterator(), false).count();
        return numOfEntries;

    }
}
