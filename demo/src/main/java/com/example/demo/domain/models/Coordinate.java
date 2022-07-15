package com.example.demo.domain.models;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
@Builder
@NoArgsConstructor
public class Coordinate {
    private Double x;
    private Double y;
}
