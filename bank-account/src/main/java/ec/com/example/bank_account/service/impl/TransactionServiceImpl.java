package ec.com.example.bank_account.service.impl;

import ec.com.example.bank_account.dto.TransactionRequestDTO;
import ec.com.example.bank_account.dto.TransactionResponseDTO;
import ec.com.example.bank_account.entity.Transaction;
import ec.com.example.bank_account.mapper.TransactionMapper;
import ec.com.example.bank_account.repository.AccountRepository;
import ec.com.example.bank_account.repository.TransactionRepository;
import ec.com.example.bank_account.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final TransactionMapper transactionMapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public ResponseEntity<TransactionResponseDTO> createTransaction(TransactionRequestDTO transactionRequestDTO) {
        try {
            Transaction transaction = transactionMapper.mapToEntity(transactionRequestDTO);

            if (transaction.getAccount() != null && "ACTIVE".equals(transaction.getAccount().getStatus())) {

                if (!transaction.getTypeTransaction().getTransactionCost() &&
                        transaction.getTypeTransaction().getValue() >= transaction.getValue())
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

                Double balance = transaction.getAccount().getAvailableBalance() - transaction.getTypeTransaction().getValue();

                if (transaction.getTypeTransaction().getDiscount()) {
                    if (balance >= transaction.getValue()) {
                        balance -= transaction.getValue();
                    } else {
                        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                    }
                } else {
                    balance += transaction.getValue();
                }
                transaction.getAccount().setAvailableBalance(balance);

                accountRepository.saveAndFlush(transaction.getAccount());
                transactionRepository.save(transaction);
                return ResponseEntity.status(HttpStatus.CREATED).build();

            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<List<TransactionResponseDTO>> getTransactions() {
        try {
            List<TransactionResponseDTO> response = transactionRepository.findAll()
                    .stream().map(transactionMapper::mapToDTO).collect(Collectors.toList());

            return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
