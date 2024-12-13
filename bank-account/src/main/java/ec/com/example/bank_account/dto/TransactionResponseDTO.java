package ec.com.example.bank_account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class TransactionResponseDTO implements Serializable {

    private Double value;
    private Date date;
    private String status;
    private AccountResponseDTO account;
    private TypeTransactionResponseDTO typeTransaction;

}