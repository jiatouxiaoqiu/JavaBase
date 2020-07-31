package cn.ebing.dog.api.utils.singleton;

import java.io.*;

public class LazySingleton3Test {
	public static void main(String[] args) {
		try {
			LazySingleton4 instance1 = LazySingleton4.getInstance();
			ObjectOutput out = null;

			out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
			out.writeObject(instance1);
			out.close();

			//deserialize from file to object
			ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
			LazySingleton4 instance2 = (LazySingleton4) in.readObject();
			in.close();

			System.out.println("instance1 hashCode=" + instance1.hashCode());
			System.out.println("instance2 hashCode=" + instance2.hashCode());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
