package com.line;

import com.line.domain.Hospital;
import com.line.domain.Patient;
import com.line.parser.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LineReader<T> {
    Parser<T> parser;
    boolean isRemoveColumnName = true;

    public LineReader(Parser<T> parser) {
        this.parser = parser;
    }

    public LineReader(Parser<T> parser, boolean isRemoveColumnName) {
        this.parser = parser;
        this.isRemoveColumnName = isRemoveColumnName;
    }

    public List<T> readLines(String filename) throws IOException {
        List<T> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str;
        if(isRemoveColumnName) {
            br.readLine();
        }
        while((str = br.readLine()) != null) {
            result.add(parser.parse(str));
        }
        return result;
    }


    public void creatFile(String filename) {
        File file = new File(filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writer(List<Hospital> hospitalList, String filename) throws IOException {
        File file = new File(filename);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        writer.write("INSERT INTO `likelion`.`seoul_hosipital`(`id`,`address`,`district`,`category`,`emergency_room`, `name`, `subdivision`)\nVALUES\n");
        for (Hospital hospital : hospitalList) {
            writer.write("("+"'"+hospital.getId()+"'"+","
                    +"'"+hospital.getAddress()+"'"+","
                    +"'"+hospital.getDistrict()+"'"+","
                    +"'"+hospital.getCategory()+"'"+","
                    +hospital.getEmergencyRoom()+","
                    +"'"+hospital.getName()+"'"+","
                    +"'"+hospital.getSubdivision()+"'"+"),\n");
        }
    }


    public static void main(String[] args) throws IOException {

        String filename = "C:\\Users\\안락한곳\\Downloads\\서울시 병의원 위치 정보.csv";

    }
}
