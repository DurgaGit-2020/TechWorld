package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADMINUSER_TBL")
public class Admin_User {
	@Id
	@GeneratedValue
	private int userId;
	private NameFile name;
	private String accountStatus;
	private String accessDetails;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public NameFile getName() {
		return name;
	}
	public void setName(NameFile name) {
		this.name = name;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getAccessDetails() {
		return accessDetails;
	}
	public void setAccessDetails(String accessDetails) {
		this.accessDetails = accessDetails;
	}	
}
