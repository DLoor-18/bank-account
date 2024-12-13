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
public class CardRequestDTO implements Serializable {

    @NotNull
    @Size(max = 30)
    @Pattern(regexp = "^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$")
    private String holderName;
    @NotNull
    private Double limitation;
    @NotNull
    @Size(min = 3, max = 3)
    @Pattern(regexp = "^[0-9]+$")
    private String cvcCode;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date expirationDate;
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$")
    private String status;
    @NotNull
    private Long accountId;

}