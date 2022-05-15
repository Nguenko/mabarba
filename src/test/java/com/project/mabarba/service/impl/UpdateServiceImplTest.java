package com.project.mabarba.service.impl;

import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import com.project.mabarba.payload.request.CoiffeurRequest;
import com.project.mabarba.payload.request.SalonRequest;
import com.project.mabarba.repository.CoiffeurRepository;
import com.project.mabarba.repository.SalonRepository;
import com.project.mabarba.service.UpdateService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



@ExtendWith(MockitoExtension.class)
class UpdateServiceImplTest {

    @Mock
    private UpdateService service;

    @Mock
    private SalonRepository salonRepository;

    @Mock
    private CoiffeurRepository coiffeurRepository;

    @Captor
    private ArgumentCaptor<Salon> postArgumentCaptor;

    @Captor
    private ArgumentCaptor<Coiffeur> barberArgumentCaptor;

    private String dDate="2022-05-12 15:32:52";
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private Date cDate = df.parse(dDate);

    UpdateServiceImplTest() throws ParseException {
    }


    @Test
    void salonCreation() {
        long salonId = 376l;
        Salon salon = new Salon(salonId, "Beauty", "23774563489",false, cDate);
        SalonRequest salonRequest = new SalonRequest(salonId, "Beauty", "23774563489");
        service.salonCreation(salonRequest);
        Mockito.when(salonRepository.save(salon)).thenReturn(salon);
        Mockito.verify(salonRepository, Mockito.times(1)).save(postArgumentCaptor.capture());
        Assertions.assertThat(postArgumentCaptor.getValue().getTelephone()).isEqualTo("23774563489");


    }

    @Test
    void salonModification() {

    }

    @Test
    void barberCreation() {
        long coifeurId = 376l;
        Coiffeur coiffeur = new Coiffeur(coifeurId, "Beauty", "23774563489",false, cDate);
        CoiffeurRequest barberRequest = new CoiffeurRequest(coifeurId, "Beauty", "23774563489");
        service.barberCreation(barberRequest);
        Mockito.when(coiffeurRepository.save(coiffeur)).thenReturn(coiffeur);
        Mockito.verify(coiffeurRepository, Mockito.times(1)).save(barberArgumentCaptor.capture());
        Assertions.assertThat(barberArgumentCaptor.getValue().getTelephone()).isEqualTo("23774563489");
        //     assertEquals(salon.getTelephone(), service.salonCreation(salonRequest).getTelephone());
    }

    @Test
    void barberModification() {
    }
}