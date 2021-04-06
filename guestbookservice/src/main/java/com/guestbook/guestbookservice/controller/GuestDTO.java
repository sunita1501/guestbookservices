package com.guestbook.guestbookservice.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collector;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestDTO {
    String name;
    String comment;

    public void collect(Collector<Object,?, List<Object>> toList) {
    }
}
