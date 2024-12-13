package ec.com.example.bank_account.repository;

import ec.com.example.bank_account.entity.TypeAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeAccountRepository extends JpaRepository<TypeAccount, Long> {

    TypeAccount save(TypeAccount typeAccount);

    List<TypeAccount> findAll();

}