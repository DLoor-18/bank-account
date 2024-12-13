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

    @NotNull
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$")
    private String firstName;
    @NotNull
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$")
    private String lastName;
    @NotNull
    @Pattern(regexp = "^[0-9]+$")
    @Size(min = 10, max = 10)
    private String ci;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).+$")
    @Size(min = 8, max = 16)
    private String password;
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$")
    private String status;

}