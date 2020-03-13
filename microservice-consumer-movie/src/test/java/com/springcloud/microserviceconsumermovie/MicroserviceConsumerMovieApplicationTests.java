package com.springcloud.microserviceconsumermovie;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

@SpringBootTest
class MicroserviceConsumerMovieApplicationTests {

	public static Integer function(int i, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
		return function1.andThen(function2).apply(i);
	}

	public
	@Test
	void contextLoads() {
		Integer result = function(1, x -> x * 10, y -> y + 5);
		System.out.println(result);

	}

}
