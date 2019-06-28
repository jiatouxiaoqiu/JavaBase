package cn.ebing.dog.api.domain.response;

import java.util.Date;

public class UserResponse {

	private Integer id;

	private String name;

	private Integer age;

	private Integer sex;

	private Boolean marry;

	private Date createdAt;

	public UserResponse(Integer id, String name, Integer age, Integer sex, Boolean marry, Date createdAt) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.marry = marry;
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

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public void setMarry(Boolean marry) {
		this.marry = marry;
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

	public Integer getSex() {
		return sex;
	}

	public Boolean getMarry() {
		return marry;
	}
}
