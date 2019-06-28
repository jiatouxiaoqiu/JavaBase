package cn.ebing.dog.api.domain.request;

public class UserRequest {

	private String name;

	private Integer age;

	private Integer sex;

	private Boolean marry;


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
