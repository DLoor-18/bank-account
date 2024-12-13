package ec.com.example.bank_account.service.impl;

import ec.com.example.bank_account.dto.TypeAccountRequestDTO;
import ec.com.example.bank_account.dto.TypeAccountResponseDTO;
import ec.com.example.bank_account.mapper.TypeAccountMapper;
import ec.com.example.bank_account.repository.TypeAccountRepository;
import ec.com.example.bank_account.service.TypeAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TypeAccountServiceImpl implements TypeAccountService {

    private final TypeAccountRepository typeAccountRepository;
    private final TypeAccountMapper typeAccountMapper;

    public TypeAccountServiceImpl(TypeAccountRepository typeAccountRepository, TypeAccountMapper typeAccountMapper) {
        this.typeAccountRepository = typeAccountRepository;
        this.typeAccountMapper = typeAccountMapper;
    }

    @Override
    public ResponseEntity<TypeAccountResponseDTO> createTypeAccount(TypeAccountRequestDTO typeAccount) {
        try {
            typeAccountRepository.save(typeAccountMapper.mapToEntity(typeAccount));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.error("Error en createTypeAccount() {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public ResponseEntity<List<TypeAccountResponseDTO>> getAllTypeAccount() {
        try {
           List<TypeAccountResponseDTO> response =  typeAccountRepository.findAll()
                   .stream().map(typeAccountMapper::mapToDTO).collect(Collectors.toList());

           return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error en getAllTypeAccount() {}", e.getMessage());
            throw e;
        }
    }
}