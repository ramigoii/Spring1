package com.example.FitnessApp.service.impl;

import com.example.FitnessApp.dto.GymDto;
import com.example.FitnessApp.mapper.GymMapper;
import com.example.FitnessApp.model.Gym;
import com.example.FitnessApp.repository.GymRepository;
import com.example.FitnessApp.service.GymService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class GymServiceImpl implements GymService {
    private final GymRepository gymRepository;
    private final GymMapper gymMapper;
    @Override
    public List<GymDto> getAll() {
        return gymMapper.toDtoList(gymRepository.findAll());
    }

    @Override
    public GymDto getById(Long id) {
        return gymMapper.toDto(gymRepository.findById(id).orElseThrow());
    }

    @Override
    public void addGym(GymDto gymDto) {
        gymRepository.save(gymMapper.toEntity(gymDto));
    }

    @Override
    public void updateGym(Long id, GymDto gymDto) {
        Gym gym = gymMapper.toEntity(gymDto);
        gym.setId(id);
        gymRepository.save(gym);

    }

    @Override
    public void deleteGym(Long id) {
        gymRepository.deleteById(id);
    }
}
