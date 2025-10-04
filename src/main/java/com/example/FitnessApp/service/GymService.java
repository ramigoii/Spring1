package com.example.FitnessApp.service;

import com.example.FitnessApp.dto.GymDto;
import com.example.FitnessApp.model.Gym;

import java.util.List;

public interface GymService {
    List<GymDto> getAll();
    GymDto getById(Long id);
    void addGym(GymDto gymDto);
    void updateGym(Long id, GymDto gymDto);
    void deleteGym(Long id);
}
