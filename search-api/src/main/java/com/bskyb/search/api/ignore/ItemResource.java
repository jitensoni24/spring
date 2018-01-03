package com.bskyb.search.api.ignore;

public class ItemResource {

	private Integer st;
	
	private Integer no;
	
	private String name;
	
	private Integer endTime;

	public Integer getSt() {
		return st;
	}

	public void setSt(Integer st) {
		this.st = st;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Temp [st=" + st + ", no=" + no + ", name=" + name + ", endTime=" + endTime + "]";
	}

}
