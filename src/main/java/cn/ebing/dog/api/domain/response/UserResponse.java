package cn.ebing.dog.api.domain.response;

import java.util.Date;

public class UserResponse {

	private Integer id;

	private String name;

	private Integer age;

	private Boolean sex;

	private Date createdAt;

	public UserResponse(Integer id, String name, Integer age, Boolean sex, Date createdAt) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.createdAt = createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public Boolean getSex() {
		return sex;
	}
}
