package ec.com.example.bank_account.service;

import ec.com.example.bank_account.dto.UserRequestDTO;
import ec.com.example.bank_account.dto.UserResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<Void> createUser(UserRequestDTO user);

    ResponseEntity<List<UserResponseDTO>> getAllUsers();

    ResponseEntity<UserResponseDTO> getUserByCi(String ci);

}
