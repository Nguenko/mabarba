package com.project.mabarba.service.impl;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import com.project.mabarba.models.User;
import com.project.mabarba.payload.request.CoiffeurRequest;
import com.project.mabarba.payload.request.SalonRequest;
import com.project.mabarba.repository.CoiffeurRepository;
import com.project.mabarba.repository.SalonRepository;
import com.project.mabarba.repository.UserRepository;
import com.project.mabarba.service.RetrieveService;
import com.project.mabarba.service.UpdateService;
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
class UpdateServiceImplTest {

    @Autowired
    private UpdateService service;

    @Autowired
    private RetrieveService rService;

    @MockBean
    private SalonRepository salonRepository;

    @MockBean
    private CoiffeurRepository coiffeurRepository;

    String dDate="2022-05-12 15:32:52";
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Date cDate = df.parse(dDate);

    UpdateServiceImplTest() throws ParseException {
    }


    @Test
    void barberDeleted() throws NoDataFoundException {
        //given
        long coiffeurId = 376l;
        Coiffeur coiffeur = new Coiffeur(coiffeurId, "Beauty", "23774563489",false, cDate);
        Coiffeur coiffeurDeleted = new Coiffeur(coiffeurId, "Beauty", "23774563489",true, cDate);
        //when
        CoiffeurRequest coiffeurRequest = new CoiffeurRequest(coiffeurId, "Beauty", "23774563489");
        when(coiffeurRepository.save(coiffeur)).thenReturn(coiffeur);
        when(coiffeurRepository.deleteCoiffeurById(true,coiffeurId)).thenReturn(Optional.of(coiffeurDeleted));
        //then
        System.out.println();
        System.out.println(rService.barberDeleted(coiffeurId));
//        assertEquals(coiffeurDeleted, rService.barberDeleted(coiffeurId));
    }


    @Test
    void salonCreation() {
        long salonId = 376l;
        Salon salon = new Salon(salonId, "Beauty", "23774563489",false, cDate);
        SalonRequest salonRequest = new SalonRequest(salonId, "Beauty", "23774563489");
        when(salonRepository.save(salon)).thenReturn(salon);
        assertEquals(salon, service.salonCreation(salonRequest));

    }

    @Test
    void salonModification() {
        long salonId = 376l;
        Salon salon = new Salon(salonId, "Beauty", "23774563489",false, cDate);
        SalonRequest salonRequest = new SalonRequest(salonId, "Beauty", "23774563489");
        salon.setNom("Steven");
        salonRequest.setNom("Steven");
        when(salonRepository.save(salon)).thenReturn(salon);
        assertEquals(salon, service.salonModification(salonRequest));
        assertEquals("Steven",salon.getNom());
        assertEquals("Steven",service.salonModification(salonRequest).getNom());
    }

    @Test
    void barberCreation() {
        long coiffeurId = 376l;
        Coiffeur coiffeur = new Coiffeur(coiffeurId, "Beauty", "23774563489",false, cDate);
        CoiffeurRequest coiffeurRequest = new CoiffeurRequest(coiffeurId, "Beauty", "23774563489");
        when(coiffeurRepository.save(coiffeur)).thenReturn(coiffeur);
        assertEquals(coiffeur, service.barberCreation(coiffeurRequest));
    }

    @Test
    void barberModification() {
        long salonId = 376l;
        Coiffeur coiffeur = new Coiffeur(salonId, "Beauty", "23774563489",false, cDate);
        CoiffeurRequest coiffeurRequest = new CoiffeurRequest(salonId, "Beauty", "23774563489");
        coiffeur.setNom("Steven");
        coiffeurRequest.setNom("Steven");
        when(coiffeurRepository.save(coiffeur)).thenReturn(coiffeur);
        assertEquals(coiffeur, service.barberModification(coiffeurRequest));
        assertEquals("Steven",coiffeur.getNom());
        assertEquals("Steven",service.barberModification(coiffeurRequest).getNom());
    }
}