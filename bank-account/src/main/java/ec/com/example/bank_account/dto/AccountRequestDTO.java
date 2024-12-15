package ec.com.example.bank_account.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class AccountRequestDTO implements Serializable {

    @NotNull(message = "number cannot be null")
    @Pattern(regexp = "^[0-9]+$", message = "Incorrect number format")
    @Size(min = 10, max = 10, message = "Incorrect number length")
    private String number;
    @NotNull(message = "availableBalance cannot be null")
    private BigDecimal availableBalance;
    @NotNull(message = "retainedBalance cannot be null")
    private BigDecimal retainedBalance;
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "Incorrect status")
    private String status;
    @NotNull(message = "userId cannot be null")
    private String userId;
    @NotNull(message = "typeAccountId cannot be null")
    private String typeAccountId;
}
