package com.project.mabarba.service.impl;

import com.project.mabarba.repository.CoiffeurRepository;
import com.project.mabarba.repository.SalonRepository;
import com.project.mabarba.service.RetrieveService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RetrieveServiceImplTest {

    @Mock   private SalonRepository salonRepository;
    //private  AutoCloseable autoCloseable;
    private CoiffeurRepository coiffeurRepository;
    private RetrieveService underTest;

    @BeforeEach
    void setUp(){
       // autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new RetrieveServiceImpl();
    }

//    @AfterEach
//    void tearDown() throws Exception{
//        autoCloseable.close();
//    }

    @Test
    @Disabled
    void salonDisplayed() {
    }

    @Test
    @Disabled
    void salonDeleted() {
    }

    @Test
    @Disabled
    void barberDisplayed() {
    }

    @Test
    @Disabled
    void barberDeleted() {
    }

    @Test
    void salonDisplayedList() {
        //when
        underTest.salonDisplayedList();

        //then

        verify(salonRepository).findAll();
    }

    @Test
    @Disabled
    void barberDisplayedList() {
    }

    @Test
    @Disabled
    void salonDisplayedPage() {
    }

    @Test
    @Disabled
    void barberDisplayedPage() {
    }
}