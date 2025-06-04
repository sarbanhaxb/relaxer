package com.example.relaxer.services.impl;

import com.example.relaxer.DTO.AccountDTO;
import com.example.relaxer.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    @Override
    public AccountDTO create(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO update(Long id, AccountDTO accountDTO) {
        return null;
    }

    @Override
    public List<AccountDTO> getAll() {
        return List.of();
    }

    @Override
    public AccountDTO findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
