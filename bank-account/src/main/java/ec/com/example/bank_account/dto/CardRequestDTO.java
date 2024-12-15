package ec.com.example.bank_account.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CardRequestDTO implements Serializable {

    @NotNull(message = "holderName cannot be null")
    @Size(max = 30, message = "holderName exceeds allowed length")
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$", message = "Incorrect holderName format")
    private String holderName;
    @NotNull(message = "limitation cannot be null")
    private BigDecimal limitation;
    @NotNull(message = "cvcCode cannot be null")
    @Size(min = 3, max = 3, message = "Incorrect cvcCode length")
    @Pattern(regexp = "^[0-9]+$", message = "Incorrect cvcCode format")
    private String cvcCode;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date expirationDate;
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "Incorrect status")
    private String status;
    @NotNull(message = "accountId cannot be null")
    private String accountId;

}