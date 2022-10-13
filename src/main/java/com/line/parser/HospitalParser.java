package com.line.parser;

import com.line.domain.Hospital;



public class HospitalParser implements Parser<Hospital> {

    @Override
    public Hospital parse(String str) {
        // 데이터에 " 있을경우, 라인을 받을 때부터 모든 "를 제외 한다.
        // str = str.replaceAll("\"", " ");
        String[] splitted = str.split("\\,");
        String[] splitted2 = splitted[1].split(" ");
        String district = String.format("%s %s", splitted2[0], splitted2[1]);
        return new Hospital(splitted[0], splitted[1], district, splitted[2], Integer.parseInt(splitted[6]), splitted[10], subdiv(splitted[10]));
    }

    public String subdiv(String str) {
        String subdiv = "";
        String[] inputCheck = {"내과", "외과", "소아", "피부", "성형", "정형외과", "척추", "교정", "산부인과", "관절", "봉합", "화상", "골절", "영유아", "안과", "가정", "비뇨", "치과"};
        String[] result = {"내과", "외과", "소아", "피부", "성형", "정형외과", "척추", "교정", "산부인과", "관절", "봉합", "화상", "골절", "영유아", "안과", "가정", "비뇨", "치과"};

        for (int i = 0; i < inputCheck.length; i++) {
            if (str.contains(inputCheck[i])) {
                subdiv = result[i];
            }
        }
        return subdiv;
    }
}
