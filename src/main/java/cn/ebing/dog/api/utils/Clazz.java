package cn.ebing.dog.api.utils;

public class Clazz {
	Clazz(int a) {}
	Clazz() {}
	private int member = 3;
}

class SonClazz extends Clazz {}

class SonClazz2 extends Clazz {
	SonClazz2() {
		super(123);
	}
}
