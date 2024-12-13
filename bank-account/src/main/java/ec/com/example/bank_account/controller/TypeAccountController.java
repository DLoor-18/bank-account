package ec.com.example.bank_account.controller;

import ec.com.example.bank_account.dto.TypeAccountRequestDTO;
import ec.com.example.bank_account.dto.TypeAccountResponseDTO;
import ec.com.example.bank_account.service.TypeAccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types-account")
public class TypeAccountController {

    private final TypeAccountService typeAccountService;

    public TypeAccountController(TypeAccountService typeAccountService) {
        this.typeAccountService = typeAccountService;
    }

    @PostMapping
    public ResponseEntity<TypeAccountResponseDTO> createTypeAccount(@Valid @RequestBody TypeAccountRequestDTO typeAccount) {
        return typeAccountService.createTypeAccount(typeAccount);
    }

    @GetMapping
    public ResponseEntity<List<TypeAccountResponseDTO>> getTypesAccount() {
        return typeAccountService.findAll();
    }
}