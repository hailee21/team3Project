package kr.or.ksmart.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LmsApplication {

	public static void main(String[] args) {
		System.out.println("=======================tomcat 실행 전==========================");
		SpringApplication.run(LmsApplication.class, args);
		System.out.println("=======================Spring 구동 후==========================");
	}

}
