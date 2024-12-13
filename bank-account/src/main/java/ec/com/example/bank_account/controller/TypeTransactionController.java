package ec.com.example.bank_account.controller;

import ec.com.example.bank_account.dto.TypeTransactionRequestDTO;
import ec.com.example.bank_account.dto.TypeTransactionResponseDTO;
import ec.com.example.bank_account.service.TypeTransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types-transaction")
public class TypeTransactionController {
    private final TypeTransactionService typeTransactionService;

    public TypeTransactionController(TypeTransactionService typeTransactionService) {
        this.typeTransactionService = typeTransactionService;
    }

    @PostMapping
    public ResponseEntity<TypeTransactionResponseDTO> createTypeTransaction(@Valid @RequestBody TypeTransactionRequestDTO typeTransaction) {
        return typeTransactionService.createTypeTransaction(typeTransaction);
    }

    @GetMapping
    public ResponseEntity<List<TypeTransactionResponseDTO>> getAllTypeTransactions() {
        return typeTransactionService.getAllTypeTransactions();
    }

}