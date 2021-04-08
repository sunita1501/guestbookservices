package com.guestbook.guestbookservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static sun.security.krb5.internal.KDCOptions.with;

@SpringBootTest
@AutoConfigureMockMvc//(addFilters = false)
@AutoConfigureRestDocs
public class GuestbookIT {

    @Autowired
    MockMvc mockmvc;

    @Test
    public void postGuest() throws Exception {

        GuestDTO guestDTO = new GuestDTO("Guest1", "Comment1");
        ObjectMapper objectMapper = new ObjectMapper();
        mockmvc.perform(post("/guest")
                .content(objectMapper.writeValueAsString(guestDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(document("AddGuest"));
    }

    @Test
    public void getGuest() throws Exception{

        GuestDTO guestDTO = new GuestDTO("Guest1", "Comment1");
        ObjectMapper objectMapper = new ObjectMapper();
        mockmvc.perform(post("/guest")
                .content(objectMapper.writeValueAsString(guestDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(document("AddGuest"));

        mockmvc.perform(get("/guest")).andExpect(status().isOk())
                .andExpect(jsonPath("[0].name").value("Guest1"))
                .andDo(document("Guest", responseFields(
                        fieldWithPath("[0].name").description("First Guest"),
                        fieldWithPath("[0].comment").description("First Guest Comment"))));
    }
}
