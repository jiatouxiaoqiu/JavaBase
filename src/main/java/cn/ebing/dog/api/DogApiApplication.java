package cn.ebing.dog.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("cn.ebing.dog.api.mapper")
@SpringBootApplication
public class DogApiApplication {

	public static void main(String[] args) {
		System.out.println("===== DogApiApplication 准备启动 =====");
		byte [] b1 = new byte[4 * 1024 * 1024];
//		SpringApplication.run(DogApiApplication.class, args);
		System.out.println("===== DogApiApplica tion 启动完成 =====");
	}

}
