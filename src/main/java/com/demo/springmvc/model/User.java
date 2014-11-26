package com.demo.springmvc.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	private int userId;
	@NotEmpty(message="{username.not.empty}")
	private String username;
	@NotEmpty(message="{password.not.empty}")
	private String password;
	@NotEmpty(message="邮件不能为空")
	private String email;
	private String telephone;
	private String sex;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", telephone=" + telephone + ", username=" + username + ", password=" + password + ", sex=" + sex + "]";
	}

}
