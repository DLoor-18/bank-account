package ec.com.example.bank_account.service;

import ec.com.example.bank_account.dto.TypeTransactionRequestDTO;
import ec.com.example.bank_account.dto.TypeTransactionResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TypeTransactionService {

    ResponseEntity<TypeTransactionResponseDTO> createTypeTransaction(TypeTransactionRequestDTO typeTransaction);

    ResponseEntity<List<TypeTransactionResponseDTO>> getAllTypeTransactions();

}
