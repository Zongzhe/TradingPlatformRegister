package com.fdm.model;



public class User {
	
	private String userName = "";
	private String password = "";
	private String firstName = "";
	private String lastName = "";
	private boolean enable = false;
	private int role = 0;
	
	public User(){
		
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public String getPassWord(){
		return password;
	}
	
	public void setPassword(String passWord){
		this.password = passWord;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public boolean isEnable(){
		return enable;
	}
	
	public void setEnable(boolean enable){
		this.enable = enable;
	}
	
	public int getRole(){
		return role;
	}
	
	public void setRole(int role){
		this.role = role;
	}

}
