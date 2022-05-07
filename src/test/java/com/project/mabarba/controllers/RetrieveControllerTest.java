package com.project.mabarba.controllers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.sound.midi.Receiver;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(RetrieveController.class)
class RetrieveControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void hello() {
        //given
        RetrieveController retrieveController = new RetrieveController();
        //when
        String response = retrieveController.hello("world");

        //then
        assertEquals("hello, world", response);
    }

    @Test
    void helloTest() throws Exception{
        //given
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/helloTest");
        MvcResult result = mvc.perform(requestBuilder).andReturn();
        assertEquals("hello world", result.getResponse().getContentAsString());
        RetrieveController retrieveController = new RetrieveController();
        //when
        String response = retrieveController.hello("world");

        //then
        assertEquals("hello, world", response);
    }

//    @Test
//    public void helloTestWithName() throws Exception{
//        //given
//        mvc.perform(get("/helloTest?name=Steve")).andExpect(content().string("Hello Steve"));
//        //when
//       // String response = retrieveController.hello("world");
//
//        //then
//        //assertEquals("hello, world", response);
//    }



    @Test
    @Disabled
    void salonDisplayed() {
    }

    @Test
    @Disabled
    void barberDisplayed() {
    }

    @Test
    @Disabled
    void salonDisplayedList() {
    }

    @Test
    @Disabled
    void barberDisplayedList() {
    }

    @Test
    @Disabled
    void barberDisplayedPage() {
    }

    @Test
    @Disabled
    void salonDisplayedPage() {
    }


}