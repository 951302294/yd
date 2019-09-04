package com.bw.entity;


public class Cin_Type implements java.io.Serializable {

	//columns START
	private Integer id;
	private Integer cid;
	private Integer tid;
	//columns END
	public Cin_Type(){
	}
	public Cin_Type(Integer id,Integer cid,Integer tid){
		this.id=id;		this.cid=cid;		this.tid=tid;	}

	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
	}

	public void setCid(Integer cid){
		this.cid=cid;
	}
	public Integer getCid(){
		return cid;
	}

	public void setTid(Integer tid){
		this.tid=tid;
	}
	public Integer getTid(){
		return tid;
	}
}

