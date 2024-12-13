package ec.com.example.bank_account.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "available_balance")
    private Double availableBalance;

    @Column(name = "retained_balance")
    private Double retainedBalance;

    @Column(name = "status")
    private String status;

    @JoinColumn(name = "id_user")
    @ManyToOne
    private User user;

    @JoinColumn(name = "id_type_account")
    @ManyToOne
    private TypeAccount typeAccount;

    @OneToMany(mappedBy = "account", orphanRemoval = true)
    private List<Card> cards;

    @OneToMany(mappedBy = "account", orphanRemoval = true)
    private List<Transaction> transactions;

}