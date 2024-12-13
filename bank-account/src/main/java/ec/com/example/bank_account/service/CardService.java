package ec.com.example.bank_account.service;

import ec.com.example.bank_account.dto.CardRequestDTO;
import ec.com.example.bank_account.dto.CardResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CardService {

    ResponseEntity<CardResponseDTO> createCard(CardRequestDTO card);

    ResponseEntity<List<CardResponseDTO>> getAllCards();

}