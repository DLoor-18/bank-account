package ec.com.example.bank_account.service.impl;

import ec.com.example.bank_account.dto.AccountRequestDTO;
import ec.com.example.bank_account.dto.AccountResponseDTO;
import ec.com.example.bank_account.mapper.AccountMapper;
import ec.com.example.bank_account.repository.AccountRepository;
import ec.com.example.bank_account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public ResponseEntity<AccountResponseDTO> createAccount(AccountRequestDTO accountRequestDTO) {
        try {
            accountRepository.save(accountMapper.mapToEntity(accountRequestDTO));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<List<AccountResponseDTO>> getAllAccounts() {
        try {
            List<AccountResponseDTO> response = accountRepository.findAll().stream()
                    .map(accountMapper::mapToDTO).collect(Collectors.toList());

            return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
