package com.example.FitnessApp.service;
import com.example.FitnessApp.dto.GymDto;
import java.util.List;

public interface GymService {
    List<GymDto> getAll();
    GymDto getById(Long id);
    GymDto addGym(GymDto gymDto);
    GymDto updateGym(Long id, GymDto gymDto);
    Boolean deleteGym(Long id);
}
