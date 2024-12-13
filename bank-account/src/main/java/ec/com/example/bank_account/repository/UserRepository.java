package ec.com.example.bank_account.repository;

import ec.com.example.bank_account.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    List<User> findAll();

    User findByCi(String ci);

}