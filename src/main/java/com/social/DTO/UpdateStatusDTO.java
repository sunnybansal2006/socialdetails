package com.social.DTO;

public class UpdateStatusDTO {
	private Integer id;
	
	private String name;
	
	private String sex;
	
	private String location;
	
	private String mobilenumber;
	
	private String email;
	
	private String birthday;
	
	
		public String getname() {
		return name;
	}

	public String getsex() {
		return sex;
	}

	public String getlocation() {
		return location;
	}

	public String getmobilenumber() {
		return mobilenumber;
	}

	public String getemail() {
		return email;
	}

	public String getbirthday() {
		return birthday;
	}

	
   	public void setname(String name) {
		this.name = name;
	}

	public void setsex(String sex) {
		this.sex = sex;
	}

	public void setlocation(String location) {
		this.location = location;
	}

	public void setmobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public void setbirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
	}
	
	

}
