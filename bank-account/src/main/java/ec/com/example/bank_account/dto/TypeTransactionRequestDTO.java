package ec.com.example.bank_account.dto;

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

    @NotNull
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ -]+$")
    private String type;
    @NotNull
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ .,;]+$")
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