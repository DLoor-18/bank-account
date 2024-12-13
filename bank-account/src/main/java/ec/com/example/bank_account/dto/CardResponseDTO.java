package ec.com.example.bank_account.dto;

import ec.com.example.bank_account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CardResponseDTO implements Serializable {

    private String holderName;
    private Double limitation;
    private String cvcCode;
    private Date expirationDate;
    private String status;
    private AccountResponseDTO account;

}