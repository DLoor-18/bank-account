package ec.com.example.bank_account.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank
    private String accountNumber;
    @NotBlank
    private String details;
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$")
    private String status;
    @NotNull
    private Long typeTransactionId;

}