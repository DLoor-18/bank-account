package ec.com.example.bank_account.service.impl;

import ec.com.example.bank_account.dto.CardRequestDTO;
import ec.com.example.bank_account.dto.CardResponseDTO;
import ec.com.example.bank_account.mapper.CardMapper;
import ec.com.example.bank_account.repository.CardRepository;
import ec.com.example.bank_account.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
    public CardResponseDTO createCard(CardRequestDTO card) {
        try {
            return cardMapper.mapToDTO(cardRepository.save(cardMapper.mapToEntity(card)));
        } catch (Exception e) {
            log.error("Error en createCard() {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<CardResponseDTO> getAllCards() {
        try {
            List<CardResponseDTO> response = cardRepository.findAll().stream()
                    .map(cardMapper::mapToDTO).collect(Collectors.toList());

            return !response.isEmpty() ? response : Collections.emptyList();
        } catch (Exception e) {
            log.error("Error en getAllCards() {}", e.getMessage());
            throw e;
        }
    }
}