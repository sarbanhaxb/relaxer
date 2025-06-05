package com.example.relaxer.controllers;

import com.example.relaxer.DTO.HobbyDTO;
import com.example.relaxer.services.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hobby")
public class HobbyController {
    private final HobbyService hobbyService;

    @GetMapping
    public ResponseEntity<List<HobbyDTO>> getHobby(){
        return ResponseEntity.ok().body(hobbyService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HobbyDTO> getHobbyById(@PathVariable Long id){
        return ResponseEntity.ok().body(hobbyService.findById(id));
    }

    @PostMapping
    public ResponseEntity<HobbyDTO> createHobby(@RequestBody HobbyDTO hobbyDTO){
        return ResponseEntity.ok().body(hobbyService.create(hobbyDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HobbyDTO> updateHobby(@RequestBody HobbyDTO hobbyDTO, @PathVariable Long id){
        return ResponseEntity.ok().body(hobbyService.update(id, hobbyDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HobbyDTO> deleteHobby(@PathVariable Long id){
        hobbyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
