package ec.com.example.bank_account.controller;

import ec.com.example.bank_account.dto.UserRequestDTO;
import ec.com.example.bank_account.dto.UserResponseDTO;
import ec.com.example.bank_account.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserRequestDTO user) {
        UserResponseDTO response = userService.createUser(user);
        return response != null ?
                ResponseEntity.ok().build() :
                ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> response = userService.getAllUsers();
        return !response.isEmpty() ?
                ResponseEntity.ok().body(response) :
                ResponseEntity.noContent().build();

    }

    @GetMapping("/find-ci/{ci}")
    public ResponseEntity<UserResponseDTO> getUserByCi(@PathVariable("ci") String ci) {
        UserResponseDTO response = userService.getUserByCi(ci);
        return response != null ?
                ResponseEntity.ok().body(response) :
                ResponseEntity.badRequest().build();
    }

}