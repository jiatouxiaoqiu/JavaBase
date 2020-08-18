package cn.ebing.dog.api.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * comparable and Comparator
 */
class User{
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public User() {

	}
}

//待比较的实体类
class User2 implements Comparable<User2>{
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User2(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public User2() {

	}

	@Override
	public int compareTo(User2 o) {
		return this.getAge() - o.getAge();
	}
}

//比较器，实现Comparator接口
class UserCompare implements Comparator<User> {
	@Override
	public int compare(User o1, User o2) {
		return o1.getAge() - o2.getAge();
	}
}

public class CompareTest {
	public static void main(String[] args) {
		User user1 = new User(20, "李四");
		User user2 = new User(18, "张三");
		User user3 = new User(23, "王五");

		ArrayList<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);

		System.out.println("排序前");
		for (User user : userList) {
			System.out.println(user.getAge()+":"+user.getName());
		}
		Collections.sort(userList, new UserCompare()); //把比较器传进去
		System.out.println("排序后");
		for (User user : userList) {
			System.out.println(user.getAge()+":"+user.getName());
		}
	}
}