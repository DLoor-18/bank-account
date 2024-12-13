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
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class TransactionRequestDTO implements Serializable {

    @NotNull
    private Double value;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;
    @NotNull
    @Size(min = 10, max = 10)
    @Pattern(regexp = "^[0-9]+$")
    private String accountNumber;
    @NotNull
    @Size(max = 150)
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ .,;]+$")
    private String details;
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$")
    private String status;
    @NotNull
    private Long typeTransactionId;

}