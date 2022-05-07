package com.project.mabarba.service.impl;

import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import com.project.mabarba.payload.request.SalonRequest;
import com.project.mabarba.repository.CoiffeurRepository;
import com.project.mabarba.repository.SalonRepository;
import com.project.mabarba.service.UpdateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.web.client.HttpClientErrorException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


class UpdateServiceImplTest {

    private CoiffeurRepository coiffeurRepository;
    private SalonRepository salonRepository;
    private UpdateService underTest;

    @BeforeEach
    void setUp(){
        underTest = new UpdateServiceImpl();
    }

    @Test
    void salonCreation() {
        //given
        SalonRequest salon = new SalonRequest("salon labelle","674253980");
        //when
        underTest.salonCreation(salon);
        //salonRepository.save(salon);
        //then
        ArgumentCaptor<Salon> argumentCaptor = ArgumentCaptor.forClass(Salon.class);
        verify(salonRepository).save(argumentCaptor.capture());

        Salon capturedSalon = argumentCaptor.getValue();

        assertThat(capturedSalon).isEqualTo(salon);
    }


    @Test
    void willThrowWhenEmailsTaken() {
        //given
        SalonRequest salonrequest = new SalonRequest("salon Ma Jolie","674253980");
        //when
        //underTest.salonCreation(salonrequest);
        given(salonRepository.findByNom("salon Ma Jolie")).willReturn(true);
        //salonRepository.save(salon);
        //then
        assertThatThrownBy(()->underTest.salonCreation(salonrequest))
                .isInstanceOf(Exception.class)
                .hasMessageContaining(salonrequest.getTelephone());
        ArgumentCaptor<Salon> argumentCaptor = ArgumentCaptor.forClass(Salon.class);
        //verify(salonRepository).save(argumentCaptor.capture());

        //Salon capturedSalon = argumentCaptor.getValue();

       // assertThat(capturedSalon).isEqualTo(salon);
    }



    @Test
    @Disabled
    void salonModification() {
    }

    @Test
    @Disabled
    void barberCreation() {
    }

    @Test
    @Disabled
    void barberModification() {
    }
}