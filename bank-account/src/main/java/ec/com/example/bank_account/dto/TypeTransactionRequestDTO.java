package ec.com.example.bank_account.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class TypeTransactionRequestDTO implements Serializable {

    @NotBlank
    private String type;
    @NotBlank
    private String description;
    @NotNull
    private Double value;
    @NotNull
    private Boolean transactionCost;
    @NotNull
    private Boolean discount;
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$")
    private String status;

}