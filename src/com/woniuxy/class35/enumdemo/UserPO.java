package com.woniuxy.class35.enumdemo;

@Table("newstudents")
public class UserPO {
	@Column("sno")
	private int sno;
	@Column("sname")
	private String sname;
	@Column("ssex")
	private String ssex;
	@Column("sage")
	private int sage;
	
	public UserPO(){
		
	}
	public UserPO(int id,String name,String pass){
		this.sno = sno;
		this.sname = sname;
		this.ssex = ssex;
		this.sage = sage;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	
}
