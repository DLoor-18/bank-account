package ec.com.example.bank_account.repository;

import ec.com.example.bank_account.entity.TypeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeTransactionRepository extends JpaRepository<TypeTransaction, Long> {

    TypeTransaction save(TypeTransaction typeTransaction);

    List<TypeTransaction> findAll();

}