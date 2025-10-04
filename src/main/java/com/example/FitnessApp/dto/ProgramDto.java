package com.example.FitnessApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramDto {
    private long id;
    private String nameDto;
    private String descriptionDto;
}
