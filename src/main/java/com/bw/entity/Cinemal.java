package com.bw.entity;


public class Cinemal implements java.io.Serializable {

	//columns START
	private Integer cid;
	private String cname;
	private String cdesc;
	private String author;
	private String begintime;
	
	private String tname;
	private String tid;
	//columns END
	public Cinemal(){
	}

	public void setCid(Integer cid){
		this.cid=cid;
	}
	public Integer getCid(){
		return cid;
	}

	public void setCname(String cname){
		this.cname=cname;
	}
	public String getCname(){
		return cname;
	}

	public void setCdesc(String cdesc){
		this.cdesc=cdesc;
	}
	public String getCdesc(){
		return cdesc;
	}

	public void setAuthor(String author){
		this.author=author;
	}
	public String getAuthor(){
		return author;
	}

	public void setBegintime(String begintime){
		this.begintime=begintime;
	}
	public String getBegintime(){
		return begintime;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "Cinemal [cid=" + cid + ", cname=" + cname + ", cdesc=" + cdesc
				+ ", author=" + author + ", begintime=" + begintime
				+ ", tname=" + tname + ", tid=" + tid + "]";
	}



	public Cinemal(Integer cid, String cname, String cdesc, String author,
			String begintime, String tname, String tid) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cdesc = cdesc;
		this.author = author;
		this.begintime = begintime;
		this.tname = tname;
		this.tid = tid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}
	
	
}

