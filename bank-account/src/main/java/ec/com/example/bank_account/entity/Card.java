package ec.com.example.bank_account.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "holder_name")
    private String holderName;

    @Column(name = "limitation")
    private Double limitation;

    @Column(name = "cvc_code")
    private String cvcCode;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "status")
    private String status;

    @JoinColumn(name = "id_account")
    @ManyToOne
    private Account account;

}