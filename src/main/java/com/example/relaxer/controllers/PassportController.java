package com.example.relaxer.controllers;

import com.example.relaxer.DTO.PassportDTO;
import com.example.relaxer.services.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/passport")
public class PassportController {
    private final PassportService passportService;

    @GetMapping
    public ResponseEntity<List<PassportDTO>> getPassport(){
        return ResponseEntity.ok().body(passportService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassportDTO> getPassportById(@PathVariable Long id){
        return ResponseEntity.ok().body(passportService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PassportDTO> createPassport(@RequestBody PassportDTO passportDTO){
        return ResponseEntity.ok().body(passportService.create(passportDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassportDTO> updatePassport(@RequestBody PassportDTO passportDTO, @PathVariable Long id){
        return ResponseEntity.ok().body(passportService.update(id, passportDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PassportDTO> deletePassport(@PathVariable Long id){
        passportService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
