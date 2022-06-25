package com.project.mabarba;

import com.project.mabarba.models.User;
import com.project.mabarba.repository.CoiffeurRepository;
import com.project.mabarba.repository.SalonRepository;
import com.project.mabarba.repository.UserRepository;
import com.project.mabarba.service.UserRetrieveService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MabarbaApplicationTests {


	@Autowired
	private UserRetrieveService userRetrieveService;

	@MockBean
	private UserRepository repository;

	@MockBean
	private SalonRepository salonRepository;


	@MockBean
	private CoiffeurRepository coiffeurRepository;

	@Test
	void contextLoads() {
	}
//	@Test
//	public void getUsersTest() {
//		when(repository.findAll()).thenReturn(Stream
//		.of(new User(376, "Danile", "danielle@gmail.com", "Dani@12345"),
//		    new User(958, "Steve", "steve@gmail.com", "Steve@12345"))
//				.collect(Collectors.toList()));
//		assertEquals(2, userRetrieveService.userDisplayedList().size());
//	}
}
