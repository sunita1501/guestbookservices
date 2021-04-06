package com.guestbook.guestbookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuestController {
    @Autowired
    GuestService guestService;

    @PostMapping("/guest")
    public GuestDTO addGuest(@RequestBody GuestDTO guestDTO){
        return guestService.postGuest(guestDTO);
    }

    @GetMapping("/guest")
    public List<GuestDTO> getGuest(){
        return guestService.getAll();
    }
}
