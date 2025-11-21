package com.example.FitnessApp.service.impl;

import com.example.FitnessApp.dto.GymDto;
import com.example.FitnessApp.mapper.GymMapper;
import com.example.FitnessApp.model.Gym;
import com.example.FitnessApp.repository.GymRepository;
import com.example.FitnessApp.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class GymServiceImpl implements GymService {
    private final GymRepository gymRepository;
    private final GymMapper gymMapper;
    @Override
    public List<GymDto> getAll() {
        return gymMapper.toDtoList(gymRepository.findAll());
    }

    @Override
    public GymDto getById(Long id) {
        return gymMapper.toDto(gymRepository.findById(id).orElse(null));
    }

    @Override
    public GymDto addGym(GymDto gymDto) {
        Gym gym = gymRepository.save(gymMapper.toEntity(gymDto));
        return gymMapper.toDto(gym);
    }

    @Override
    public GymDto updateGym(Long id, GymDto gymDto) {
        Gym gym = gymRepository.findById(id).orElse(null);
        Gym gymEnt = gymMapper.toEntity(gymDto);

        gym.setId(gymEnt.getId());
        gym.setName(gymEnt.getName());
        gym.setCity(gymEnt.getCity());
        return gymMapper.toDto(gymRepository.save(gym));

    }

    @Override
    public Boolean deleteGym(Long id) {
        gymRepository.deleteById(id);
        Gym gym = gymRepository.findById(id).orElse(null);
        if(Objects.isNull(gym)){
            return true;
        }
        return false;
    }
}
