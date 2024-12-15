package ec.com.example.bank_account.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class UserRequestDTO implements Serializable {

    @NotNull(message = "firstName cannot be null")
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$", message = "Incorrect firstName format")
    private String firstName;
    @NotNull(message = "lastName cannot be null")
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$", message = "Incorrect lastName format")
    private String lastName;
    @NotNull(message = "ci cannot be null")
    @Pattern(regexp = "^[0-9]+$", message = "Incorrect ci format")
    @Size(min = 10, max = 10, message = "Incorrect ci length")
    private String ci;
    @NotNull(message = "email cannot be null")
    @Email( message = "Invalid email")
    private String email;
    @NotNull(message = "password cannot be null")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).+$", message = "Incorrect password format")
    @Size(min = 8, max = 16, message = "Incorrect password length")
    private String password;
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "Incorrect status")
    private String status;

}