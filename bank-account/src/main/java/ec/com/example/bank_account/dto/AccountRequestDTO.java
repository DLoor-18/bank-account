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
public class AccountRequestDTO implements Serializable {

    @NotNull
    @Pattern(regexp = "^[0-9]+$")
    @Size(min = 10, max = 10)
    private String number;
    @NotNull
    private Double availableBalance;
    @NotNull
    private Double retainedBalance;
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$")
    private String status;
    @NotNull
    private Long userId;
    @NotNull
    private Long typeAccountId;
}
