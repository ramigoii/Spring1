package com.example.FitnessApp;

import com.example.FitnessApp.dto.ProgramDto;
import com.example.FitnessApp.mapper.ProgramMapper;
import com.example.FitnessApp.model.Category;
import com.example.FitnessApp.model.Program;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class ProgramMapperTest {
    @Autowired
    private ProgramMapper programMapper;

    @Test
    void convertEntityToDtoTest(){
        Program entityProgram = new Program(1L, "first", "first Programm", new Category(), new ArrayList<>());
        ProgramDto dtoProgram = programMapper.toDto(entityProgram);

        Assertions.assertNotNull(dtoProgram);

        Assertions.assertNotNull(dtoProgram.getId());
        Assertions.assertNotNull(dtoProgram.getNameDto());
        Assertions.assertNotNull(dtoProgram.getDescriptionDto());

        Assertions.assertEquals(entityProgram.getId(), dtoProgram.getId());
        Assertions.assertEquals(entityProgram.getName(), dtoProgram.getNameDto());
        Assertions.assertEquals(entityProgram.getDescription(), dtoProgram.getDescriptionDto());

    }

    @Test
    void convertDtoToEntityTest(){
        ProgramDto dtoProgram = new ProgramDto(1L, "first", "first Programm");
        Program entityProgram = programMapper.toEntity(dtoProgram);

        Assertions.assertNotNull(entityProgram);

        Assertions.assertNotNull(entityProgram.getId());
        Assertions.assertNotNull(entityProgram.getName());
        Assertions.assertNotNull(entityProgram.getDescription());

        Assertions.assertEquals(dtoProgram.getId(), entityProgram.getId());
        Assertions.assertEquals(dtoProgram.getNameDto(), entityProgram.getName());
        Assertions.assertEquals(dtoProgram.getDescriptionDto(), entityProgram.getDescription());

    }

    @Test
    void convertListProgramEntityToListProgramDtoTest(){
        List<Program> entityList = new ArrayList<>();
        entityList.add(new Program(1L, "first", "klsflskdf ", new Category(), new ArrayList<>()));
        entityList.add(new Program(2L, "second", "khgkgguj", new Category(), new ArrayList<>()));
        entityList.add(new Program(3L, "third", "khgugjbj", new Category(), new ArrayList<>()));

        List<ProgramDto> dtoList = programMapper.toDtoList(entityList);

        Assertions.assertNotNull(dtoList);

        Assertions.assertNotEquals(0, dtoList.size());

        Assertions.assertEquals(entityList.size(), dtoList.size());

        for(int i = 0; i < entityList.size(); i++ ){

            Program entityProgram = entityList.get(i);

            ProgramDto dtoProgram = programMapper.toDto(entityProgram);
            Assertions.assertNotNull(dtoProgram);

            Assertions.assertNotNull(dtoProgram.getId());
            Assertions.assertNotNull(dtoProgram.getNameDto());
            Assertions.assertNotNull(dtoProgram.getDescriptionDto());

            Assertions.assertEquals(entityProgram.getId(), dtoProgram.getId());
            Assertions.assertEquals(entityProgram.getName(), dtoProgram.getNameDto());
            Assertions.assertEquals(entityProgram.getDescription(), dtoProgram.getDescriptionDto());
        }

    }

}
