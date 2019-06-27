package cn.ebing.dog.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DogApiApplication {

	public static void main(String[] args) {
		System.out.println("-- DogApiApplication 准备启动 --");
		SpringApplication.run(DogApiApplication.class, args);
		System.out.println("-- DogApiApplication 启动完成 --");
	}

}
