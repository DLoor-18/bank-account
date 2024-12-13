package ec.com.example.bank_account.service.impl;

import ec.com.example.bank_account.dto.CardRequestDTO;
import ec.com.example.bank_account.dto.CardResponseDTO;
import ec.com.example.bank_account.mapper.CardMapper;
import ec.com.example.bank_account.repository.CardRepository;
import ec.com.example.bank_account.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardServiceImpl(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }


    @Override
    public ResponseEntity<CardResponseDTO> createCard(CardRequestDTO card) {
        try {
            cardRepository.save(cardMapper.mapToEntity(card));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<List<CardResponseDTO>> getAllCards() {
        try {
            List<CardResponseDTO> response = cardRepository.findAll().stream()
                    .map(cardMapper::mapToDTO).collect(Collectors.toList());

            return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}