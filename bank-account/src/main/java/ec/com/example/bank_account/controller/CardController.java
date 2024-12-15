package ec.com.example.bank_account.controller;

import ec.com.example.bank_account.dto.CardRequestDTO;
import ec.com.example.bank_account.dto.CardResponseDTO;
import ec.com.example.bank_account.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Card RESTful", description = "Endpoints for card management.")
@RestController
@RequestMapping("/api/cards")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @Operation(summary = "Create new card", description = "Create a new card from the request data.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Card created successfully."),
            @ApiResponse(responseCode = "404", description = "No resources found."),
            @ApiResponse(responseCode = "500", description = "Internal application problems.")
    })
    @PostMapping
    public ResponseEntity<CardResponseDTO> createCard(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Body with the card data to be created", required = true)
            @Valid @RequestBody CardRequestDTO card) {
        CardResponseDTO response = cardService.createCard(card);
        return response != null ?
                ResponseEntity.status(201).body(response) :
                ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Get all card", description = "Get all registered cards.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully obtained all registered cards."),
            @ApiResponse(responseCode = "404", description = "No resources found."),
            @ApiResponse(responseCode = "500", description = "Internal application problems.")
    })
    @GetMapping
    public ResponseEntity<List<CardResponseDTO>> getAllCards() {
        List<CardResponseDTO> response = cardService.getAllCards();
        return !response.isEmpty() ?
                ResponseEntity.ok().body(response) :
                ResponseEntity.noContent().build();
    }

}