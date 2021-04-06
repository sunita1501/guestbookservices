package com.guestbook.guestbookservice.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Long>{

        GuestEntity findByName(String name);

}
