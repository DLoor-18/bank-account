package ec.com.example.bank_account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class TypeTransactionResponseDTO implements Serializable {

    private String type;
    private String description;
    private Double value;
    private Boolean transactionCost;
    private Boolean discount;
    private String status;

}