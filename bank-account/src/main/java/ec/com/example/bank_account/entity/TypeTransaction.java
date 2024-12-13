package ec.com.example.bank_account.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "types_transaction")
public class TypeTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
    private Double value;

    @Column(name = "transaction_cost")
    private Boolean transactionCost;

    @Column(name = "discount")
    private Boolean discount;

    @Column(name = "status")
    private String status;
}