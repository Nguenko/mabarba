package com.project.mabarba;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.BiFunction;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class MabarbaApplicationTests {

	Calculator underTest = new Calculator();

	@Test
	void itShouldAddNumbers() {
		//given
		int numberOne = 20;
		int numberTwo = 30;

		//when
		int result = underTest.add(numberOne, numberTwo);

		//then
		int expected = 50;
		assertThat(result).isEqualTo(expected);
	}

	@Test
	void itShouldAddNumbersFunctional() {
		//given
		int numberOne = 25;
		int numberTwo = 30;

		//when
		int result = underTest.adds.apply(numberOne, numberTwo);

		//then
		int expected = 55;
		assertThat(result).isEqualTo(expected);
	}

	class Calculator {
		int add(int a, int b) {
			return a+b;
		}

		BiFunction<Integer, Integer, Integer> adds =( a, b)->  a+b;
	}

}
