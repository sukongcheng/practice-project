package com.springcloud.microserviceprovideruser;

import com.springcloud.microserviceprovideruser.dao.UserRepository;
import com.springcloud.microserviceprovideruser.entity.User;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProviderUserApplication.class, args);
	}

	@Bean
	ApplicationRunner init(UserRepository userRepository){
		return args -> {
			User user1 = User.builder().id(1L).username("account1").name("张三").age(20).balance(new BigDecimal("100.00")).build();
			User user2 = User.builder().id(2L).username("account2").name("李四").age(28).balance(new BigDecimal("180.00")).build();
			User user3 = User.builder().id(3L).username("account3").name("王五").age(33).balance(new BigDecimal("200.00")).build();
			Stream.of(user1, user2, user3).forEach(userRepository::save);
		};
	}
}
