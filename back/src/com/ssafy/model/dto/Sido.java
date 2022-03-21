package com.ssafy.model.dto;

public class Sido {
    private String sidoCode;
    private String sidoName;
    public Sido(String sidoCode, String sidoName) {
        this.sidoCode = sidoCode;
        this.sidoName = sidoName;
    }
    public String getSidoCode() {
        return sidoCode;
    }
    public void setSidoCode(String sidoCode) {
        this.sidoCode = sidoCode;
    }
    public String getDixoName() {
        return sidoName;
    }
    public void setDixoName(String sidoName) {
        this.sidoName = sidoName;
    }
}
