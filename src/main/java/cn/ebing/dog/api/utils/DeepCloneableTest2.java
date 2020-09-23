package cn.ebing.dog.api.utils;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 说明：对象的clone方法默认是浅拷贝，若想实现深拷贝需要重写clone方法实现属性对象 的拷贝。
 */
public class DeepCloneableTest2 {

	public static void main(String[] args) throws Exception {
		// 初始化一个对象
		Person person = new Person("平头",20,"123456@qq.com","技术");
		// 复制对象
		Person person1 = (Person) person.clone();
		// 改变 person1 的属性值
		person1.name = "我是平头的克隆对象";
		// 修改 person age 的值
		person1.setAge(22);
		person1.setDesc("我已经关注了技术");
		System.out.println("person对象："+person.personDesc.desc);
		System.out.println();
		System.out.println("person1对象："+person1.personDesc.getDesc());
	}

	public static class Person implements Serializable {

		private static final long serialVersionUID = 369285298572941L;
		// 姓名
		private String name;
		// 年龄
		private int age;
		// 邮件
		private String email;

		private PersonDesc personDesc;

		public static long getSerialVersionUID() {
			return serialVersionUID;
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

		public Person(String name, int age, String email, String desc) {
			this.name = name;
			this.age = age;
			this.email = email;
			this.personDesc = new PersonDesc();
			this.personDesc.setDesc(desc);
		}

		@Override
		public Person clone() {
			Person person = null;
			try { // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos);
				oos.writeObject(this);
				// 将流序列化成对象
				ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
				ObjectInputStream ois = new ObjectInputStream(bais);
				person = (Person) ois.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return person;
		}

		public void setDesc(String desc) {
			this.personDesc.setDesc(desc);
		}
	}
	public static class PersonDesc implements Serializable {

		private static final long serialVersionUID = 872390113109L;
		// 描述
		private String desc;

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

	}
}
