package ec.com.example.bank_account.service.impl;

import ec.com.example.bank_account.dto.TypeTransactionRequestDTO;
import ec.com.example.bank_account.dto.TypeTransactionResponseDTO;
import ec.com.example.bank_account.mapper.TypeTransactionMapper;
import ec.com.example.bank_account.repository.TypeTransactionRepository;
import ec.com.example.bank_account.service.TypeTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TypeTransactionServiceImpl implements TypeTransactionService {
    private final TypeTransactionRepository typeTransactionRepository;
    private final TypeTransactionMapper typeTransactionMapper;

    public TypeTransactionServiceImpl(TypeTransactionRepository typeTransactionRepository, TypeTransactionMapper typeTransactionMapper) {
        this.typeTransactionRepository = typeTransactionRepository;
        this.typeTransactionMapper = typeTransactionMapper;
    }

    @Override
    public ResponseEntity<TypeTransactionResponseDTO> createTypeTransaction(TypeTransactionRequestDTO typeTransaction) {
        try {
            typeTransactionRepository.save(typeTransactionMapper.mapToEntity(typeTransaction));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.error("Error en createTypeTransaction() {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public ResponseEntity<List<TypeTransactionResponseDTO>> getAllTypeTransactions() {
        try {
            List<TypeTransactionResponseDTO> response = typeTransactionRepository.findAll()
                    .stream().map(typeTransactionMapper::mapToDTO).collect(Collectors.toList());

            return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error en getAllTypeTransactions() {}", e.getMessage());
            throw e;
        }
    }
}
