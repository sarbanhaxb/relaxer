package com.example.relaxer.services;

import com.example.relaxer.DTO.HobbyDTO;
import com.example.relaxer.entity.Hobby;

import java.util.List;

public interface HobbyService {
    HobbyDTO create(HobbyDTO hobbyDTO);
    HobbyDTO update(Long id, HobbyDTO hobbyDTO);
    void delete(Long id);
    List<HobbyDTO> getAll();
    HobbyDTO findById(Long id);
}
