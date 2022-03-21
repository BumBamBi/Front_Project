package com.ssafy.model.dto;

public class HouseInfo {
    private int aptCode;
    private String aptName;
    private String dongCode;
    private String dongName;
    private int buildYear;
    private String jibun;
    private String lat;
    private String lng;
    private String img;
    
    public HouseInfo(int aptCode, String aptName, String dongCode, String dongName, int buildYear, String jibun,
            String lat, String lng, String img) {
        this.aptCode = aptCode;
        this.aptName = aptName;
        this.dongCode = dongCode;
        this.dongName = dongName;
        this.buildYear = buildYear;
        this.jibun = jibun;
        this.lat = lat;
        this.lng = lng;
        this.img = img;
    }


    public int getAptCode() {
        return aptCode;
    }

    public void setAptCode(int aptCode) {
        this.aptCode = aptCode;
    }

    public String getAptName() {
        return aptName;
    }

    public void setAptName(String aptName) {
        this.aptName = aptName;
    }

    public String getDongCode() {
        return dongCode;
    }

    public void setDongCode(String dongCode) {
        this.dongCode = dongCode;
    }

    public String getDongName() {
        return dongName;
    }

    public void setDongName(String dongName) {
        this.dongName = dongName;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    public String getJibun() {
        return jibun;
    }

    public void setJibun(String jibun) {
        this.jibun = jibun;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
