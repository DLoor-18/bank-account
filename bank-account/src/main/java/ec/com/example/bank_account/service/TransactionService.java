package ec.com.example.bank_account.service;

import ec.com.example.bank_account.dto.TransactionRequestDTO;
import ec.com.example.bank_account.dto.TransactionResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransactionService {

    ResponseEntity<TransactionResponseDTO> createTransaction(TransactionRequestDTO transactionRequestDTO);

    ResponseEntity<List<TransactionResponseDTO>> getTransactions();

}