package ec.com.example.bank_account.service.impl;

import ec.com.example.bank_account.dto.UserRequestDTO;
import ec.com.example.bank_account.dto.UserResponseDTO;
import ec.com.example.bank_account.mapper.UserMapper;
import ec.com.example.bank_account.repository.UserRepository;
import ec.com.example.bank_account.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseEntity<Void> createUser(UserRequestDTO user) {
        try {
            userRepository.save(userMapper.mapToEntity(user));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.error("Error en createUser() {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        try {
            List<UserResponseDTO> response = userRepository.findAll().stream()
                    .map(userMapper::mapToDTO).collect(Collectors.toList());

            return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error en getAllUsers() {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public ResponseEntity<UserResponseDTO> getUserByCi(String ci) {
        try {
            return userRepository.findByCi(ci) != null ?
                    ResponseEntity.ok(userMapper.mapToDTO(userRepository.findByCi(ci))) :
                    ResponseEntity.noContent().build();

        } catch (Exception e) {
            log.error("Error en getUserByCi() {}", e.getMessage());
            throw e;
        }
    }
}
