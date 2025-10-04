package com.example.FitnessApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymDto {
    private Long id;
    private String nameDto;
    private String cityDto;
}
