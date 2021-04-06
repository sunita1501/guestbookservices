package com.guestbook.guestbookservice.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GuestBookServiceTest {
    @InjectMocks
    GuestService guestService;

    @Mock
    GuestRepository guestRepository;

    @Test
    public void postGuestServiceTest() {
        //object being passed
        GuestDTO guestDTO  = new GuestDTO("Guest1","Comment1");
        GuestEntity guestEntity = new GuestEntity(guestDTO.getName(),guestDTO.getComment());

        when(guestRepository.save(any())).thenReturn(guestEntity);
        //service call/. saves object and returns saved object
        GuestDTO response = guestService.postGuest(guestDTO);

        //compare saved(service call) object with heroDTO
        assertEquals(guestDTO, response);
    }



}
