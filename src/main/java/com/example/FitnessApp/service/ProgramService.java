package com.example.FitnessApp.service;
import com.example.FitnessApp.dto.ProgramDto;
import java.util.List;

public interface ProgramService {
    List<ProgramDto> getall();
    ProgramDto getById(Long id);
    ProgramDto addProgram(ProgramDto programDto);
    ProgramDto update(Long id, ProgramDto programDto);
    Boolean deleteProgram(Long id);
}
