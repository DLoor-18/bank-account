package ec.com.example.bank_account.controller;

import ec.com.example.bank_account.dto.TransactionRequestDTO;
import ec.com.example.bank_account.dto.TransactionResponseDTO;
import ec.com.example.bank_account.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(@Valid @RequestBody TransactionRequestDTO transaction) {
        TransactionResponseDTO response = transactionService.createTransaction(transaction);
        return response != null ?
                ResponseEntity.ok().body(response) :
                ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> getTransactions() {
        List<TransactionResponseDTO> response = transactionService.getAllTransactions();
        return !response.isEmpty() ?
                ResponseEntity.ok().body(response) :
                ResponseEntity.noContent().build();
    }

}