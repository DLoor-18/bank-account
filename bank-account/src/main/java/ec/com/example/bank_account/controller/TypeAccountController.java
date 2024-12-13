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
        TypeAccountResponseDTO response = typeAccountService.createTypeAccount(typeAccount);
        return response != null  ?
                ResponseEntity.ok().body(response) :
                ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<TypeAccountResponseDTO>> getTypesAccount() {
        List<TypeAccountResponseDTO> response = typeAccountService.getAllTypeAccount();
        return !response.isEmpty()  ?
                ResponseEntity.ok().body(response) :
                ResponseEntity.noContent().build();
    }
}