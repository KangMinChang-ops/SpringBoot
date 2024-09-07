package hello.hello_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		// 톰캣 웹 서버를 내장
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
