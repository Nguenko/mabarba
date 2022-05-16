package com.project.mabarba.service.impl;

import com.project.mabarba.models.Salon;
import com.project.mabarba.models.User;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
class UpdateServiceImplTest {

    @Autowired
    private UpdateService service;

    @MockBean
    private SalonRepository salonRepository;

    String dDate="2022-05-12 15:32:52";
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Date cDate = df.parse(dDate);

    UpdateServiceImplTest() throws ParseException {
    }




    @Test
    void salonCreation() {
        long salonId = 376l;
        Salon salon = new Salon(salonId, "Beauty", "23774563489",false, cDate);
        SalonRequest salonRequest = new SalonRequest(salonId, "Beauty", "23774563489");
            when(salonRepository.save(salon)).thenReturn(salon);
            assertEquals(salon.getTelephone(), service.salonCreation(salonRequest).getTelephone());

    }

    @Test
    void salonModification() {
    }

    @Test
    void barberCreation() {
    }

    @Test
    void barberModification() {
    }
}