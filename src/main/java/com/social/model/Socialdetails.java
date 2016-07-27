package com.social.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table(name = "social_master")
public class Socialdetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobilenumber")
	private String mobilenumber;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "profilepic")
	private String profilepic;
	
	@Column (name= "status")
	private String status;

	@Column (name= "error")
	private String error;
	
	public Integer getid() {
		return id;
	}

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

	public String getprofilepic() {
		return profilepic;
	}
	
	public String getstatus() {
		return status;
	}
	
	public String geterror() {
		return error;
	}
	
	
	
	public void getstatus(String status) {
		this.status = status;
	}

	public void setid(Integer id) {
		this.id = id;
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

	public void setprofilepic(String profilepic) {
		this.profilepic = profilepic;
	}

	public void setstatus(String status) {
		this.status = status;
	}
	
	public void seterror(String error) {
		this.error = error;
	}
		
}
