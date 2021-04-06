package com.guestbook.guestbookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService {
    @Autowired
    GuestRepository guestRepository;

    public GuestDTO postGuest(GuestDTO guestDTO){
        GuestEntity saveEntity = new GuestEntity(guestDTO.getName(),guestDTO.getComment());
        GuestEntity saved = guestRepository.save(saveEntity);
        return new GuestDTO(saved.getName(),saved.getComment());
    }

    public List<GuestDTO> getAll() {
        List<GuestEntity> guestEntityList = guestRepository.findAll();
        return guestEntityList.stream().map(guestEntity ->
                new GuestDTO(guestEntity.getName(),guestEntity.getComment()))
                .collect(Collectors.toList());
    }

}
