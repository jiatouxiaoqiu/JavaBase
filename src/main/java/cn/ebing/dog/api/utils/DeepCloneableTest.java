package cn.ebing.dog.api.utils;

public class DeepCloneableTest {

	public static void main(String[] args) throws Exception {
		// 初始化一个对象
		Person person = new Person("平头2",20,"123456@qq.com","技术");
		// 复制对象
		Person person1 = (Person) person.clone();
		// 改变 person1 的属性值
		person1.setName("我是平头的克隆对象2");
		// 修改 person age 的值
		person1.setAge(22);
		person1.setDesc("我已经关注了技术2");
		System.out.println("person对象2：" + person.personDesc.desc);
		System.out.println("person1对象2：" + person1.personDesc.desc);
	}

	// 新增 PersonDesc
	public static class PersonDesc implements Cloneable {
		// 描述
		private String desc;

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		@Override
		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}
	public static class Person implements Cloneable {
		// 姓名
		private String name;
		// 年龄
		private int age;
		// 邮件
		private String email;
		// 将原来的 string desc 变成了 PersonDesc 对象，这样 personDesc 就是引用类型
		private PersonDesc personDesc;

		@Override
		public Object clone() throws CloneNotSupportedException {
			Person person = (Person)super.clone();
			// 需要将引用对象也克隆一次
			person.personDesc = (PersonDesc) personDesc.clone();
			return person;
		}

		public void setDesc(String desc) {
			this.personDesc.setDesc(desc);
		}
		public Person(String name, int age, String email, String desc) {
			this.name = name;
			this.age = age;
			this.email = email;
			this.personDesc = new PersonDesc();
			this.personDesc.setDesc(desc);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public PersonDesc getPersonDesc() {
			return personDesc;
		}

		public void setPersonDesc(PersonDesc personDesc) {
			this.personDesc = personDesc;
		}
	}
}
