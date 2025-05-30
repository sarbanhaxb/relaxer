package com.example.relaxer.DTO;

import com.example.relaxer.entity.Account;
import com.example.relaxer.entity.Hobby;
import com.example.relaxer.entity.Passport;
import com.example.relaxer.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

public record AccountDTO(
        @NotNull @Size(min = 2, max = 50) String title
        )
{

}



