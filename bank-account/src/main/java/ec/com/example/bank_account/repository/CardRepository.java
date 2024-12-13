package ec.com.example.bank_account.repository;

import ec.com.example.bank_account.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Card save(Card card);

    List<Card> findAll();

}