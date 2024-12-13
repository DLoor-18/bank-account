package ec.com.example.bank_account.service.impl;

import ec.com.example.bank_account.dto.AccountRequestDTO;
import ec.com.example.bank_account.dto.AccountResponseDTO;
import ec.com.example.bank_account.mapper.AccountMapper;
import ec.com.example.bank_account.repository.AccountRepository;
import ec.com.example.bank_account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO) {
        try {
            return accountMapper.mapToDTO(accountRepository.save(accountMapper.mapToEntity(accountRequestDTO)));
        } catch (Exception e) {
            log.error("Error en createAccount() {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<AccountResponseDTO> getAllAccounts() {
        try {
            List<AccountResponseDTO> response = accountRepository.findAll().stream()
                    .map(accountMapper::mapToDTO).collect(Collectors.toList());

            return !response.isEmpty() ? response : Collections.emptyList();
        } catch (Exception e) {
            log.error("Error en getAllAccounts() {}", e.getMessage());
            throw e;
        }
    }
}
