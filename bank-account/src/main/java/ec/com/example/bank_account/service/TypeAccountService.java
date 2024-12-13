package ec.com.example.bank_account.service;

import ec.com.example.bank_account.dto.TypeAccountRequestDTO;
import ec.com.example.bank_account.dto.TypeAccountResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TypeAccountService {

    ResponseEntity<TypeAccountResponseDTO> createTypeAccount(TypeAccountRequestDTO typeAccount);

    ResponseEntity<List<TypeAccountResponseDTO>> findAll();

}
