package com.bw.entity;


public class Type implements java.io.Serializable {

	//columns START
	private Integer tid;
	private String tname;
	//columns END
	public Type(){
	}
	public Type(Integer tid,String tname){
		this.tid=tid;		this.tname=tname;	}

	public void setTid(Integer tid){
		this.tid=tid;
	}
	public Integer getTid(){
		return tid;
	}

	public void setTname(String tname){
		this.tname=tname;
	}
	public String getTname(){
		return tname;
	}
}

