package cn.ebing.dog.api.domain.request;

public class UserRequest {

	private String name;

	private Integer age;

	private Boolean sex;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
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
