package com.example.FitnessApp.controller;

import com.example.FitnessApp.dto.GymDto;
import com.example.FitnessApp.model.Gym;
import com.example.FitnessApp.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gym")
public class GymApi {
    private final GymService gymService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(gymService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(gymService.getById(id), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody GymDto gymDto){
        gymService.addGym(gymDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody GymDto gymDto){
        gymService.updateGym(id, gymDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        gymService.deleteGym(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
