package com.project.mabarba.controllers;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import com.project.mabarba.models.User;
import com.project.mabarba.repository.CoiffeurRepository;
import com.project.mabarba.repository.SalonRepository;
import com.project.mabarba.repository.UserRepository;
import com.project.mabarba.service.RetrieveService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RetrieveControllerTest {

    @Autowired
    private RetrieveService service;

    @Mock
    private UserRepository repository;

    @Mock
    private SalonRepository salonRepository;


    @Mock
    private CoiffeurRepository coiffeurRepository;

    RetrieveControllerTest() throws ParseException {
    }

    @Test
    void hello() {
    }

    @Test
    void helloTest() {
    }

    private String dDate="2022-05-12 15:32:52";
    private String dDate2="2021-05-12 15:32:52";
    private String dDate3="2020-05-12 15:32:52";
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private Date cDate = df.parse(dDate);
    private Date cDate2 = df.parse(dDate2);
    private Date cDate3 = df.parse(dDate3);
    private Pageable page = PageRequest.of(0, 4);

    @Test
    void salonDisplayed() {
        //given
        long salonId = 376l;
        Salon salon = new Salon(salonId, "Beauty", "23774563489",false, cDate);
        //when

        Mockito.when(salonRepository.findByIdAndDeletedIsFalse(salonId)).thenReturn(Optional.of(salon));
        try {
          //then
        Assertions.assertThat("Beauty").isEqualTo(service.salonDisplayed(salonId).getNom());
        } catch (NoDataFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    void barberDisplayed() {
        //given
        long barberId = 376l;
        Coiffeur coiffeur = new Coiffeur(barberId, "Beauty", "23774563489",false, cDate);
        //when

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
        when(salonRepository.findAllByOrderByCreatedAtDesc()).thenReturn(Stream.of(salon,salon2,salon3).collect(Collectors.toList()));
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
        when(coiffeurRepository.findAll()).thenReturn(Stream.of(coiffeur,coiffeur2,coiffeur3).collect(Collectors.toList()));
        //then
        assertEquals(3, service.barberDisplayedList().size());
    }

    @Test
    void barberDisplayedPage() {
        //given
        Coiffeur coiffeur = new Coiffeur(376l, "Beauty", "23774563489",false, cDate);
        Coiffeur coiffeur2 = new Coiffeur(377l, "Beauty Medium", "237745634829",false, cDate2);
        Coiffeur coiffeur3 = new Coiffeur(378l, "Beauty Major", "237745634891",false, cDate3);
        List<Coiffeur> coiffeurLists = Arrays.asList(coiffeur, coiffeur2, coiffeur3);
        Page<Coiffeur> paging = new PageImpl<>(coiffeurLists.subList(0,4), page, coiffeurLists.size());
        //when
        when(coiffeurRepository.findAllByOrderByCreatedAtDesc(page)).thenReturn(paging);
        //then
        assertEquals(3, service.barberDisplayedPage(0,4).size());
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