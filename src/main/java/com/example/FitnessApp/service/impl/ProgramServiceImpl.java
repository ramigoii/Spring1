package com.example.FitnessApp.service.impl;

import com.example.FitnessApp.dto.ProgramDto;
import com.example.FitnessApp.mapper.ProgramMapper;
import com.example.FitnessApp.model.Program;
import com.example.FitnessApp.repository.ProgramRepository;
import com.example.FitnessApp.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {
    private final ProgramRepository programRepository;
    private final ProgramMapper programMapper;
    @Override
    public List<ProgramDto> getall() {
         return programMapper.toDtoList(programRepository.findAll());
    }

    @Override
    public ProgramDto getById(Long id) {
         return programMapper.toDto(programRepository.findById(id).orElseThrow());
    }

    @Override
    public void addProgram(ProgramDto programDto) {
        programRepository.save(programMapper.toEntity(programDto));
    }

    @Override
    public void update(Long id, ProgramDto programDto) {
        Program program = programRepository.findById(id).orElseThrow();
        Program programEnt = programMapper.toEntity(programDto);
        program.setId(programEnt.getId());
        program.setName(programEnt.getName());
        program.setDescription(programEnt.getDescription());
        programRepository.save(program);
    }

    @Override
    public void deleteProgram(Long id) {
        programRepository.deleteById(id);

    }
}
