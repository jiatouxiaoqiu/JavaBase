package cn.ebing.dog.api.utils.polymorphism;

class Dog extends Animal {
	@Override
	public void eat() {
		System.out.println("吃骨头");
	}
	public void work() {
		System.out.println("看家");
	}
}