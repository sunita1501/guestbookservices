package com.guestbook.guestbookservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GuestbookIT {

    @Autowired
    MockMvc mockmvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void postGuest() throws Exception {

        GuestDTO guestDTO  = new GuestDTO("Guest1","Comment1");

        mockmvc.perform(post("/guestbook/guest")
                .content(objectMapper.writeValueAsString(guestDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockmvc.perform(get("/guestbook/guest")).andExpect(status().isOk())
                .andExpect(jsonPath("[0].guestName").value("Guest1"));




    }

}
