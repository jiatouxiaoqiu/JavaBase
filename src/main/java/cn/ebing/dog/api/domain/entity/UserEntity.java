package cn.ebing.dog.api.domain.entity;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private Integer age;

	public UserEntity() { } // 需要加一个无参构造

	private Boolean sex;

	private Date createdAt;

	private Date updatedAt;

	public UserEntity(Integer id, String name, Integer age, Boolean sex, Date createdAt, Date updatedAt) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UserEntity(String name, Integer age, Boolean sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

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
