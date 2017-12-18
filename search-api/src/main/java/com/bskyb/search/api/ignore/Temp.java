package com.bskyb.search.api.ignore;

public class Temp {

	private Integer st;
	
	private Integer no;
	
	private String name;

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

	@Override
	public String toString() {
		return "Temp [st=" + st + ", no=" + no + ", name=" + name + "]";
	}
	
}
