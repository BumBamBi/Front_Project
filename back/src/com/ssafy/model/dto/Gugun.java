package com.ssafy.model.dto;

public class Gugun {
    private String gugunCode;
    private String gugunName;
    public Gugun(String gugunCode, String gugunName) {
        this.gugunCode = gugunCode;
        this.gugunName = gugunName;
    }
    public String getSidoCode() {
        return gugunCode;
    }
    public void setSidoCode(String gugunCode) {
        this.gugunCode = gugunCode;
    }
    public String getDixoName() {
        return gugunName;
    }
    public void setDixoName(String gugunName) {
        this.gugunName = gugunName;
    }
}
