package cn.ebing.dog.api.domain.entity;

import java.util.Date;

public class UserEntity {

	private Integer id;

	private String name;

	private Integer age;

	private Integer sex;

	private Boolean marry;

	public UserEntity(String name, Integer age, Integer sex, Boolean marry) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.marry = marry;
	}

	private Date createdAt;

	private Date updatedAt;

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
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
