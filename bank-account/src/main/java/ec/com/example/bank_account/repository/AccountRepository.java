package ec.com.example.bank_account.repository;

import ec.com.example.bank_account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account save(Account account);

    List<Account> findAll();

    Account findByNumber(String number);

}
