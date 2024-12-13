package ec.com.example.bank_account.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class UserRequestDTO implements Serializable {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String ci;
    @NotBlank
    @Email
    private String email;
    @Size(min = 8, max = 16)
    private String password;
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$")
    private String status;

}