package ec.com.example.bank_account.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class TypeTransactionRequestDTO implements Serializable {

    @NotNull(message = "type cannot be null")
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ -]+$", message = "Incorrect type format")
    private String type;
    @NotNull(message = "description cannot be null")
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ .,;]+$", message = "Incorrect description format")
    private String description;
    @NotNull(message = "value cannot be null")
    private BigDecimal value;
    @NotNull(message = "transactionCost cannot be null")
    private Boolean transactionCost;
    @NotNull(message = "discount cannot be null")
    private Boolean discount;
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "Incorrect status")
    private String status;

}