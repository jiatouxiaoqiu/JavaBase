package cn.ebing.dog.api.domain.entity;

//import java.time.LocalDateTime;

public class UserEntity {

	private static final long serialVersionUID = 1L;

	public UserEntity() {
	}

	private Integer id;
	private String name;
	private Integer age;
	private Boolean sex;
//	private LocalDateTime createTime;
//	private LocalDateTime updateTime;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

//	public LocalDateTime getCreateTime() {
//		return createTime;
//	}
//
//	public void setCreateTime(LocalDateTime createTime) {
//		this.createTime = createTime;
//	}

	public UserEntity(String name, Integer age, Boolean sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
}
