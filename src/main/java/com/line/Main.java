package com.line;

import com.line.domain.Hospital;
import com.line.parser.HospitalParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        HospitalParser HP = new HospitalParser();
        LineReader<Hospital> hospitalLineReader = new LineReader<>(HP);
        String filename = "C:\\Users\\안락한곳\\Downloads\\서울시 병의원 위치 정보3.csv";
        List<Hospital> lists = hospitalLineReader.readLines(filename);

        hospitalLineReader.writer(lists, "Hospital_data.sql");

        //hospitalLineReader.creatFile("Hospital_data.sql");

    }
}
