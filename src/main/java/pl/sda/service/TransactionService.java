package pl.sda.service;

import pl.sda.dto.MoveCashDto;
import pl.sda.dto.TransactionDto;
import pl.sda.dto.UserDto;
import pl.sda.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Michał Gałka on 2017-04-17.
 */
public interface TransactionService {
    BigDecimal getTransactionSum(List<Transaction> transactionList);

    List<BigDecimal> getTransactionsBalanceList(UserDto userDto);

    List<TransactionDto> getTransactionsWithBalance();

    void addTransaction(TransactionDto transactionDto);

    void removeById(Integer transId);

    List<Transaction> getAllTransactions();

    void moveBetweenAccounts(MoveCashDto moveCashDto);

}
