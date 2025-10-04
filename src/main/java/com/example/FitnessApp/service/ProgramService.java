package com.example.FitnessApp.service;

import com.example.FitnessApp.dto.ProgramDto;
import com.example.FitnessApp.model.Program;

import java.util.List;

public interface ProgramService {
    List<ProgramDto> getall();
    ProgramDto getById(Long id);
    void addProgram(ProgramDto programDto);
    void update(Long id, ProgramDto programDto);
    void deleteProgram(Long id);

}
