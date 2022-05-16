package com.project.mabarba.controllers;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import com.project.mabarba.models.User;
import com.project.mabarba.repository.CoiffeurRepository;
import com.project.mabarba.repository.SalonRepository;
import com.project.mabarba.repository.UserRepository;
import com.project.mabarba.service.RetrieveService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class RetrieveControllerTest {

    @Autowired
    private RetrieveService service;

    @MockBean
    private UserRepository repository;

    @MockBean
    private SalonRepository salonRepository;


    @MockBean
    private CoiffeurRepository coiffeurRepository;

    RetrieveControllerTest() throws ParseException {
    }

    @Test
    void hello() {
    }

    @Test
    void helloTest() {
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
    void salonDisplayed() {

        //given
        long salonId = 376l;
        Salon salon = new Salon(salonId, "Beauty", "23774563489",false, cDate);
        //when

        when(salonRepository.findByIdAndDeletedIsFalse(salonId)).thenReturn(Optional.of(salon));
        try {
          //then
            assertEquals("Beauty", service.salonDisplayed(salonId).getNom());
        } catch (NoDataFoundException e) {
            e.printStackTrace();
        }



    }
//    @Test
//    public void getUserbyAddressTest() {
//        String address = "Bangalore";
//        when(repository.findByAddress(address))
//                .thenReturn(Stream.of(new User(376, "Danile", 31, "USA")).collect(Collectors.toList()));
//        assertEquals(1, service.getUserbyAddress(address).size());
//    }
    @Test
    void barberDisplayed() {
        //given
        long barberId = 376l;
        Coiffeur coiffeur = new Coiffeur(barberId, "Beauty", "23774563489",false, cDate);
        //when
        //when(!salonRepository.findById(salonId).getNom().isEmpty())
        //      .thenReturn(true);
        when(coiffeurRepository.findByIdAndDeletedIsFalse(barberId)).thenReturn(Optional.of(coiffeur));
        try {
            //then
            assertEquals("Beauty", service.barberDisplayed(barberId).getNom());
        } catch (NoDataFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    void salonDisplayedList() {
        //given
        Salon salon = new Salon(376l, "Beauty", "23774563489",false, cDate);
        Salon salon2 = new Salon(377l, "Beauty Medium", "237745634829",false, cDate2);
        Salon salon3 = new Salon(378l, "Beauty Major", "237745634891",false, cDate3);
        //when
        when(salonRepository.findAll()).thenReturn(Stream
                .of(salon,salon2,salon3)
                .collect(Collectors.toList()));
        //then
        assertEquals(3, service.salonDisplayedList().size());
    }

    @Test
    void barberDisplayedList() {
        //given
        Coiffeur coiffeur = new Coiffeur(376l, "Beauty", "23774563489",false, cDate);
        Coiffeur coiffeur2 = new Coiffeur(377l, "Beauty Medium", "237745634829",false, cDate2);
        Coiffeur coiffeur3 = new Coiffeur(378l, "Beauty Major", "237745634891",false, cDate3);
        //when
        when(coiffeurRepository.findAll()).thenReturn(Stream
                .of(coiffeur,coiffeur2,coiffeur3)
                .collect(Collectors.toList()));
        //then
        assertEquals(3, service.barberDisplayedList().size());
    }

    @Test
    void barberDisplayedPage() {
        //given
        Coiffeur coiffeur = new Coiffeur(376l, "Beauty", "23774563489",false, cDate);
        Coiffeur coiffeur2 = new Coiffeur(377l, "Beauty Medium", "237745634829",false, cDate2);
        Coiffeur coiffeur3 = new Coiffeur(378l, "Beauty Major", "237745634891",false, cDate3);
        //when
        when(coiffeurRepository.findAll()).thenReturn(Stream
                .of(coiffeur,coiffeur2,coiffeur3)
                .collect(Collectors.toList()));
        //then
        assertEquals(3, service.barberDisplayedPage(0,3).size());
    }

    @Test
    void salonDisplayedPage() {
        //given
        Salon salon = new Salon(376l, "Beauty", "23774563489",false, cDate);
        Salon salon2 = new Salon(377l, "Beauty Medium", "237745634829",false, cDate2);
        Salon salon3 = new Salon(378l, "Beauty Major", "237745634891",false, cDate3);
        //when
        when(salonRepository.findAll()).thenReturn(Stream
                .of(salon,salon2,salon3)
                .collect(Collectors.toList()));
        //then
        assertEquals(3, service.salonDisplayedPage(0,3).size());
    }

    @Test
    void userDisplayedList() {
        when(repository.findAll()).thenReturn(Stream
                .of(new User(376, "Danile", "danielle@gmail.com", "Dani@12345",false, cDate),
                        new User(958, "Steve", "steve@gmail.com", "Steve@12345",false,cDate2))
                .collect(Collectors.toList()));
        assertEquals(2, service.userDisplayedList().size());
    }
}