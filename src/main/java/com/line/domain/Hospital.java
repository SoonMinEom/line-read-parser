package com.line.domain;

public class Hospital {
    private String id;
    private String address;
    private String district;
    private String category;
    private Integer emergencyRoom;
    private String name;
    private String subdivision;

    public Hospital(String id) {
        this.id = id;
    }

    public Hospital(String id, String address, String district, String category, int emergencyRoom, String name, String subdivision) {
        this.id = id;
        this.address = address;
        this.district = district;
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        this.subdivision = subdivision;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getCategory() {
        return category;
    }

    public Integer getEmergencyRoom() {
        return emergencyRoom;
    }

    public String getName() {
        return name;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public String getSqlInsertQuery() {
        String sql = String.format("('%s','%s','%s','%s','%s','%s','%s'),\n"
                ,this.id,this.address,this.district,this.category
                ,this.emergencyRoom,this.name,this.subdivision);

        return sql;
    }




}
