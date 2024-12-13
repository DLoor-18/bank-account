package ec.com.example.bank_account.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "types_account")
public class TypeAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "typeAccount", orphanRemoval = true)
    @JsonIgnore
    private List<Account> accounts;

}