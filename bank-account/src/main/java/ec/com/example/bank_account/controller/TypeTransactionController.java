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
        TypeTransactionResponseDTO response = typeTransactionService.createTypeTransaction(typeTransaction);
        return response != null  ?
                ResponseEntity.ok().body(response) :
                ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<TypeTransactionResponseDTO>> getAllTypeTransactions() {
        List<TypeTransactionResponseDTO> response = typeTransactionService.getAllTypeTransactions();
        return !response.isEmpty() ?
                ResponseEntity.ok().body(response) :
                ResponseEntity.noContent().build();
    }

}