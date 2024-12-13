package ec.com.example.bank_account.service.impl;

import ec.com.example.bank_account.dto.TransactionRequestDTO;
import ec.com.example.bank_account.dto.TransactionResponseDTO;
import ec.com.example.bank_account.entity.Transaction;
import ec.com.example.bank_account.mapper.TransactionMapper;
import ec.com.example.bank_account.repository.AccountRepository;
import ec.com.example.bank_account.repository.TransactionRepository;
import ec.com.example.bank_account.service.TransactionService;
import lombok.extern.slf4j.Slf4j;

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
    public TransactionResponseDTO createTransaction(TransactionRequestDTO transactionRequestDTO) {
        try {
            Transaction transaction = transactionMapper.mapToEntity(transactionRequestDTO);

            if (transaction.getAccount() != null && "ACTIVE".equals(transaction.getAccount().getStatus())) {

                if (!transaction.getTypeTransaction().getTransactionCost() &&
                        transaction.getTypeTransaction().getValue() >= transaction.getValue())
                    return null;

                Double balance = transaction.getAccount().getAvailableBalance() - transaction.getTypeTransaction().getValue();

                if (transaction.getTypeTransaction().getDiscount()) {
                    if (balance >= transaction.getValue()) {
                        balance -= transaction.getValue();
                    } else {
                        return null;
                    }
                } else {
                    balance += transaction.getValue();
                }
                transaction.getAccount().setAvailableBalance(balance);

                accountRepository.saveAndFlush(transaction.getAccount());
                return transactionMapper.mapToDTO(transactionRepository.save(transaction));

            }

            return null;

        } catch (Exception e) {
            log.error("Error en createTransaction() {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<TransactionResponseDTO> getAllTransactions() {
        try {
            return transactionRepository.findAll()
                    .stream().map(transactionMapper::mapToDTO).collect(Collectors.toList());

        } catch (Exception e) {
            log.error("Error en getAllTransactions() {}", e.getMessage());
            throw e;
        }
    }
}
