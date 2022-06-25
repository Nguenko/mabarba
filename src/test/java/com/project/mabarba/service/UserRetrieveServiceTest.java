package com.project.mabarba.service;

import com.project.mabarba.models.User;
import com.project.mabarba.repository.CoiffeurRepository;
import com.project.mabarba.repository.SalonRepository;
import com.project.mabarba.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserRetrieveServiceTest {

    @Autowired
    private UserRetrieveService userRetrieveService;

    @MockBean
    private UserRepository repository;

    @MockBean
    private SalonRepository salonRepository;


    @MockBean
    private CoiffeurRepository coiffeurRepository;

    UserRetrieveServiceTest() throws ParseException {
    }

        String dDate="2022-05-12 15:32:52";
        String dDate2="2021-05-12 15:32:52";
        String dDate3="2020-05-12 15:32:52";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date cDate = df.parse(dDate);
        Date cDate2 = df.parse(dDate2);
        Date cDate3 = df.parse(dDate3);
        Pageable page = PageRequest.of(0, 4);


    @Test
    void userDisplayedByID() {
    }

    @Test
    void userDisplayedByUserName() {
    }

    @Test
    void userDisplayedList() {
        when(repository.findAllByOrderByCreatedAtDesc()).thenReturn(Stream
                .of(new User(376, "Danile", "danielle@gmail.com", "Dani@12345",false, cDate),
                        new User(958, "Steve", "steve@gmail.com", "Steve@12345",false,cDate2))
                .collect(Collectors.toList()));
        assertEquals(2, userRetrieveService.userDisplayedList().size());
    }

    @Test
    void userDisplayedPage() {
    }

    @Test
    void salonDisplayedPage() {
    }

    @Test
    void salonDisplayed() {
    }

    @Test
    void salonDisplayedCoiffeur() {
    }

    @Test
    void salonDisplayedCoiffure() {
    }

    @Test
    void plageHoraireByCoiffeurByJour() {
    }
}