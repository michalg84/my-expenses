package dev.galka.service.account;

import dev.galka.account.domain.AccountType;
import dev.galka.dto.TransactionDto;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    void updateAccountBalance(TransactionDto transactionDto);

    BigDecimal getTotalBalance();

    List<AccountDto> getAccounts();

    List<AccountType> getAccountTypes();
}
