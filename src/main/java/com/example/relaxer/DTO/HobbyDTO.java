package com.example.relaxer.DTO;

import com.example.relaxer.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.Set;

@Builder
public record HobbyDTO(
        @NotNull
        @Size(min = 1, max = 50)
        String type
) {
}
