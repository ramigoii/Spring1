package com.example.FitnessApp;

import com.example.FitnessApp.dto.GymDto;
import com.example.FitnessApp.service.GymService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Random;
@SpringBootTest
@ActiveProfiles("test")
public class GymServiceTest{
    @Autowired
    private GymService gymService;

    private GymDto createOne(){
        GymDto gymDto = new GymDto();
        gymDto.setNameDto("test");
        gymDto.setCityDto("city");
        return gymService.addGym(gymDto);
    }
    @Test
    void getAllTest(){
        createOne();
        List<GymDto> gymDtos = gymService.getAll();

        Assertions.assertNotNull(gymDtos);

        Assertions.assertNotEquals(0,gymDtos.size());

        for(int i = 0; i < gymDtos.size();i++){
            GymDto gymDto = gymDtos.get(i);

            Assertions.assertNotNull(gymDto);
            Assertions.assertNotNull(gymDto.getId());
            Assertions.assertNotNull(gymDto.getNameDto());
            Assertions.assertNotNull(gymDto.getCityDto());

        }
    }
    @Test
    void getByIdTest(){
        createOne();
        Random random = new Random();
        int randomIndex = random.nextInt(gymService.getAll().size());
        Long someId = gymService.getAll().get(randomIndex).getId();

        GymDto gymDto = gymService.getById(someId);

        Assertions.assertNotNull(gymDto);
        Assertions.assertNotNull(gymDto.getId());
        Assertions.assertNotNull(gymDto.getNameDto());
        Assertions.assertNotNull(gymDto.getCityDto());

        GymDto check = gymService.getById(-1L);
        Assertions.assertNull(check);
    }

    @Test
    void  addGymTest(){
        createOne();
        GymDto gymDto = new GymDto();
        gymDto.setNameDto("name");
        gymDto.setCityDto("tdk");

        GymDto created = gymService.addGym(gymDto);
        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertNotNull(created.getNameDto());
        Assertions.assertNotNull(created.getCityDto());

        Assertions.assertEquals(gymDto.getNameDto(), created.getNameDto());
        Assertions.assertEquals(gymDto.getCityDto(), created.getCityDto());

        GymDto getDto = gymService.getById(created.getId());
        Assertions.assertNotNull(getDto);
        Assertions.assertNotNull(getDto.getId());
        Assertions.assertNotNull(getDto.getNameDto());
        Assertions.assertNotNull(getDto.getCityDto());

        Assertions.assertEquals(created.getId(), getDto.getId());
        Assertions.assertEquals(created.getNameDto(), getDto.getNameDto());
        Assertions.assertEquals(created.getCityDto(), getDto.getCityDto());

    }

    @Test
    void updateGymDtoTest(){
        createOne();
        Random random = new Random();
        int randomIndex = random.nextInt(gymService.getAll().size());
        Long someId = gymService.getAll().get(randomIndex).getId();

        GymDto gymDto = new GymDto();
        gymDto.setId(someId);
        gymDto.setNameDto("name");
        gymDto.setCityDto("tdk");

        GymDto before = gymService.updateGym(someId,gymDto);
        Assertions.assertNotNull(before);
        Assertions.assertNotNull(before.getId());
        Assertions.assertNotNull(before.getNameDto());
        Assertions.assertNotNull(before.getCityDto());

        Assertions.assertEquals(gymDto.getNameDto(), before.getNameDto());
        Assertions.assertEquals(gymDto.getCityDto(), before.getCityDto());

        GymDto after = gymService.getById(someId);
        Assertions.assertNotNull(after);
        Assertions.assertNotNull(after.getId());
        Assertions.assertNotNull(after.getNameDto());
        Assertions.assertNotNull(after.getCityDto());

        Assertions.assertEquals(before.getNameDto(), after.getNameDto());
        Assertions.assertEquals(before.getCityDto(), after.getCityDto());
    }

    @Test
    void deleteGymTest(){
        createOne();
        Random random = new Random();
        int randomIndex = random.nextInt(gymService.getAll().size());
        Long someId = gymService.getAll().get(randomIndex).getId();
        Assertions.assertTrue(gymService.deleteGym(someId));

        GymDto gymDto = gymService.getById(someId);
        Assertions.assertNull(gymDto);
    }
}