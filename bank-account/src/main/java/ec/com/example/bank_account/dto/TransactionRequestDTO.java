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
public class TransactionRequestDTO implements Serializable {

    @NotNull(message = "value cannot be null")
    private BigDecimal value;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;
    @NotNull(message = "accountNumber cannot be null")
    @Size(min = 10, max = 10, message = "Incorrect accountNumber length")
    @Pattern(regexp = "^[0-9]+$", message = "Incorrect accountNumber format")
    private String accountNumber;
    @NotNull(message = "details cannot be null")
    @Size(max = 150, message = "details exceeds allowed length")
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ .,;]+$", message = "Incorrect details format")
    private String details;
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "Incorrect status")
    private String status;
    @NotNull(message = "typeTransactionId cannot be null")
    private String typeTransactionId;

}