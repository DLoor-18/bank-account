package ec.com.example.bank_account.controller;

import ec.com.example.bank_account.dto.CardRequestDTO;
import ec.com.example.bank_account.dto.CardResponseDTO;
import ec.com.example.bank_account.service.CardService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public ResponseEntity<CardResponseDTO> createCard(@Valid @RequestBody CardRequestDTO card) {
        CardResponseDTO response = cardService.createCard(card);
        return response != null ?
                ResponseEntity.ok().body(response) :
                ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<CardResponseDTO>> getAllCards() {
        List<CardResponseDTO> response = cardService.getAllCards();
        return !response.isEmpty() ?
                ResponseEntity.ok().body(response) :
                ResponseEntity.noContent().build();
    }

}