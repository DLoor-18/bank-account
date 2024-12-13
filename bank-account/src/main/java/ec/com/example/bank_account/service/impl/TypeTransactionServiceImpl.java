package ec.com.example.bank_account.service.impl;

import ec.com.example.bank_account.dto.TypeTransactionRequestDTO;
import ec.com.example.bank_account.dto.TypeTransactionResponseDTO;
import ec.com.example.bank_account.mapper.TypeTransactionMapper;
import ec.com.example.bank_account.repository.TypeTransactionRepository;
import ec.com.example.bank_account.service.TypeTransactionService;
import lombok.extern.slf4j.Slf4j;

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
    public TypeTransactionResponseDTO createTypeTransaction(TypeTransactionRequestDTO typeTransaction) {
        try {
            return typeTransactionMapper.mapToDTO(typeTransactionRepository.save(typeTransactionMapper.mapToEntity(typeTransaction)));
        } catch (Exception e) {
            log.error("Error en createTypeTransaction() {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<TypeTransactionResponseDTO> getAllTypeTransactions() {
        try {
            return typeTransactionRepository.findAll()
                    .stream().map(typeTransactionMapper::mapToDTO).collect(Collectors.toList());

        } catch (Exception e) {
            log.error("Error en getAllTypeTransactions() {}", e.getMessage());
            throw e;
        }
    }
}
