package ec.com.example.bank_account.dto;

import ec.com.example.bank_account.entity.Account;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class TypeAccountRequestDTO implements Serializable {

    @NotBlank
    private String type;
    @NotBlank
    @Size(max = 100)
    private String description;
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$")
    private String status;

}