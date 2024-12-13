package ec.com.example.bank_account.service;

import ec.com.example.bank_account.dto.AccountRequestDTO;
import ec.com.example.bank_account.dto.AccountResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {

    ResponseEntity<AccountResponseDTO> createAccount(AccountRequestDTO accountRequestDTO);

    ResponseEntity<List<AccountResponseDTO>> getAllAccounts();

}
