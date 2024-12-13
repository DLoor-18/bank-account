package ec.com.example.bank_account.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "details")
    private String details;

    @Column(name = "value")
    private Double value;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private String status;

    @JoinColumn(name = "id_account")
    @ManyToOne
    private Account account;

    @JoinColumn(name = "id_type_transaction")
    @ManyToOne
    private TypeTransaction typeTransaction;

}
