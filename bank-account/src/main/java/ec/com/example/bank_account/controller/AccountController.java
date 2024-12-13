package ec.com.example.bank_account.controller;

import ec.com.example.bank_account.dto.AccountRequestDTO;
import ec.com.example.bank_account.dto.AccountResponseDTO;
import ec.com.example.bank_account.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@Valid @RequestBody AccountRequestDTO account) {
        AccountResponseDTO response = accountService.createAccount(account);
        return response != null?
                ResponseEntity.ok().body(response) :
                ResponseEntity.badRequest().build();

    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> getAccounts() {
        List<AccountResponseDTO> response = accountService.getAllAccounts();
        return !response.isEmpty() ?
                ResponseEntity.ok().body(response) :
                ResponseEntity.noContent().build();

    }
}