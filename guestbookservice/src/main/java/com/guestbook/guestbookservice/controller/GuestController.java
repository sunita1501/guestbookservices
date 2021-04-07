package com.guestbook.guestbookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestController {
    @Autowired
    GuestService guestService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/guest")
    public GuestDTO addGuest(@RequestBody GuestDTO guestDTO){
        return guestService.postGuest(guestDTO);
    }

    @GetMapping("/guest")
    public List<GuestDTO> getGuest(){
        return guestService.getAll();
    }
}
