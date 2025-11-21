package com.example.FitnessApp.service.impl;

import com.example.FitnessApp.dto.ProgramDto;
import com.example.FitnessApp.mapper.ProgramMapper;
import com.example.FitnessApp.model.Program;
import com.example.FitnessApp.repository.ProgramRepository;
import com.example.FitnessApp.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

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
         return programMapper.toDto(programRepository.findById(id).orElse(null));
    }

    @Override
    public ProgramDto addProgram(ProgramDto programDto) {
        Program program = programMapper.toEntity(programDto);
        Program saved = programRepository.save(program);

        return programMapper.toDto(saved);
    }

    @Override
    public ProgramDto update(Long id, ProgramDto programDto) {
        Program program = programRepository.findById(id).orElse(null);
        Program update = programMapper.toEntity(programDto);

        program.setName(update.getName());
        program.setDescription(update.getDescription());

        return programMapper.toDto(programRepository.save(program));
    }

    @Override
    public Boolean deleteProgram(Long id) {
        programRepository.deleteById(id);
        Program program = programRepository.findById(id).orElse(null);
        if(Objects.isNull(program)){
            return true;
        }
        return false;
    }
}
