package com.example.FitnessApp.mapper;

import com.example.FitnessApp.dto.GymDto;
import com.example.FitnessApp.model.Gym;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GymMapper {
    @Mapping(target = "nameDto",source = "name")
    @Mapping(target = "cityDto",source = "city")
    GymDto toDto(Gym gym);

    @Mapping(target = "name",source = "nameDto")
    @Mapping(target = "city",source = "cityDto")
    Gym toEntity(GymDto gymDto);

    List<GymDto> toDtoList(List<Gym> gym);
}
