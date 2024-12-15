package ec.com.example.bank_account.controller;

import ec.com.example.bank_account.dto.TransactionRequestDTO;
import ec.com.example.bank_account.dto.TransactionResponseDTO;
import ec.com.example.bank_account.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Transaction RESTful", description = "Endpoints for transaction management.")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Operation(summary = "Create new transaction", description = "Create a new transaction from the request data.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Transaction created successfully."),
            @ApiResponse(responseCode = "400", description = "Transaction rejected."),
            @ApiResponse(responseCode = "404", description = "No resources found."),
            @ApiResponse(responseCode = "500", description = "Internal application problems.")
    })
    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Body with the transaction data to be created", required = true)
            @Valid @RequestBody TransactionRequestDTO transaction) {
        TransactionResponseDTO response = transactionService.createTransaction(transaction);
        return response != null ?
                ResponseEntity.status(201).body(response) :
                ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Get all transactions", description = "Get all registered transactions.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully obtained all registered transactions."),
            @ApiResponse(responseCode = "404", description = "No resources found."),
            @ApiResponse(responseCode = "500", description = "Internal application problems.")
    })
    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> getTransactions() {
        List<TransactionResponseDTO> response = transactionService.getAllTransactions();
        return !response.isEmpty() ?
                ResponseEntity.ok().body(response) :
                ResponseEntity.noContent().build();
    }

}