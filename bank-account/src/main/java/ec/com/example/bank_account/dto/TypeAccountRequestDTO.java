package ec.com.example.bank_account.dto;

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
public class TypeAccountRequestDTO implements Serializable {


    @NotNull
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$")
    private String type;
    @NotNull
    @Size(max = 100)
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ .,;]+$")
    private String description;
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$")
    private String status;

}