package com.line.parser;

import com.line.domain.Hospital;

public class HospitalParser implements Parser<Hospital>{
    @Override
    public Hospital parse(String str) {
        String[] splitted = str.split("\\,");
        String[] splitted2 = splitted[1].split(" ");
        String district = splitted2[0]+" "+splitted2[1];
        return new Hospital(splitted[0],splitted[1],district,splitted[2],Integer.parseInt(splitted[6]),splitted[10]);
    }
}
