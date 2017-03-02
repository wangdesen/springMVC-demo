package com.demo.springmvc.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
	
	private int Id;
	
	@NotEmpty(message="{bookName.not.empty}")
	private String name;
	
	@NotEmpty(message="{bookSn.not.empty}")
	private String sn;
	
	@NotEmpty(message="用户不能为空")
	private String userId;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Book [Id=" + Id + ", name=" + name + ", sn=" + sn + ", userId="
				+ userId + "]";
	}
	
}
