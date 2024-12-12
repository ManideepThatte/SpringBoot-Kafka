package com.javatips.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class KafkaJsonMesg {
    private String name;
    private String message;
    private LocalDateTime date;
}
