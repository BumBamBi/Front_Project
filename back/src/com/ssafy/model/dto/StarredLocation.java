package com.ssafy.model.dto;

public class StarredLocation {
	private int no;
	private String sidoName;
	private String gugunName;
	private String dongName;
	private String dongCode;
	public int getNo() {
		return no;
	}
	@Override
	public String toString() {
		return "StarredLocation [no=" + no + ", sidoName=" + sidoName + ", gugunName=" + gugunName + ", dongName="
				+ dongName + ", dongCode=" + dongCode + "]";
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	public String getGugunName() {
		return gugunName;
	}
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}
	public String getDongName() {
		return dongName;
	}
	public void setDongName(String dongName) {
		this.dongName = dongName;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public StarredLocation(int no, String sidoName, String gugunName, String dongName, String dongCode) {
		super();
		this.no = no;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
		this.dongCode = dongCode;
	}
	public StarredLocation() {
		super();
	}
	

	
	
}
