package com.example.FitnessApp;

import com.example.FitnessApp.dto.GymDto;
import com.example.FitnessApp.mapper.GymMapper;
import com.example.FitnessApp.model.Gym;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class GymMapperTest {
    @Autowired
    private GymMapper gymMapper;

    @Test
    void convertEntityToDtoTest(){
        Gym gymEntity = new Gym(1L, "first","Taldyk");
        GymDto gymDto = gymMapper.toDto(gymEntity);

        Assertions.assertNotNull(gymDto);

        Assertions.assertNotNull(gymDto.getId());
        Assertions.assertNotNull(gymDto.getNameDto());
        Assertions.assertNotNull(gymDto.getCityDto());

        Assertions.assertEquals(gymEntity.getId(), gymDto.getId());
        Assertions.assertEquals(gymEntity.getName(), gymDto.getNameDto());
        Assertions.assertEquals(gymEntity.getCity(), gymDto.getCityDto());

    }

    @Test
    void convertDtoToEntity(){
        GymDto gymDto = new GymDto(1L,"first","Almaty");

        Gym gymEntity = gymMapper.toEntity(gymDto);

        Assertions.assertNotNull(gymEntity);

        Assertions.assertNotNull(gymEntity.getId());
        Assertions.assertNotNull(gymEntity.getName());
        Assertions.assertNotNull(gymEntity.getCity());

        Assertions.assertEquals(gymDto.getId(), gymEntity.getId());
        Assertions.assertEquals(gymDto.getNameDto(), gymEntity.getName());
        Assertions.assertEquals(gymDto.getCityDto(), gymEntity.getCity());

    }

    @Test
    void convertListGymEntityToListGymDto(){
        List<Gym> entityList = new ArrayList<>();
        entityList.add(new Gym(1L, "fisrt","Taldyk"));
        entityList.add(new Gym(2L, "second","Almaty"));
        entityList.add(new Gym(3L, "third","Astana"));

        List<GymDto> dtoList  = gymMapper.toDtoList(entityList);

        Assertions.assertNotNull(dtoList);

        Assertions.assertNotEquals(0,dtoList.size());
        Assertions.assertEquals(entityList.size(),dtoList.size());

        for(int i = 0; i < entityList.size();i++){
            Gym gym = entityList.get(i);

            GymDto gymDto = gymMapper.toDto(gym);

            Assertions.assertNotNull(gymDto);

            Assertions.assertNotNull(gymDto.getId());
            Assertions.assertNotNull(gymDto.getNameDto());
            Assertions.assertNotNull(gymDto.getCityDto());

            Assertions.assertEquals(gym.getId(),gymDto.getId());
            Assertions.assertEquals(gym.getName(),gymDto.getNameDto());
            Assertions.assertEquals(gym.getCity(),gymDto.getCityDto());


        }

    }

}

