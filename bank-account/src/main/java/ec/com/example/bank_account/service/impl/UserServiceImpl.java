package ec.com.example.bank_account.service.impl;

import ec.com.example.bank_account.dto.UserRequestDTO;
import ec.com.example.bank_account.dto.UserResponseDTO;
import ec.com.example.bank_account.mapper.UserMapper;
import ec.com.example.bank_account.repository.UserRepository;
import ec.com.example.bank_account.service.UserService;
import lombok.extern.slf4j.Slf4j;
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
    public UserResponseDTO createUser(UserRequestDTO user) {
        try {
            return userMapper.mapToDTO(userRepository.save(userMapper.mapToEntity(user)));
        } catch (Exception e) {
            log.error("Error en createUser() {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        try {
            return userRepository.findAll().stream()
                    .map(userMapper::mapToDTO).collect(Collectors.toList());

        } catch (Exception e) {
            log.error("Error en getAllUsers() {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public UserResponseDTO getUserByCi(String ci) {
        try {
            return userRepository.findByCi(ci) != null ?
                    userMapper.mapToDTO(userRepository.findByCi(ci)) :
                    null;

        } catch (Exception e) {
            log.error("Error en getUserByCi() {}", e.getMessage());
            throw e;
        }
    }
}
