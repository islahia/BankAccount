package org.kata.bankaccount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountTest {


    private Account account;

    @Mock
    StatementPrinter printer;

    @BeforeEach
    public void setup(){
        account = new Account(printer);
    }

    @Test
    void should_add_transaction_when_deposit_amount() {
        account.deposit(100);
        account.deposit(200);
        account.deposit(500);
        int size = account.getTransactions().size();
        Assertions.assertEquals(3, size);
        Assertions.assertTrue(account.getTransactions().getFirst().getBalance()==100);
        Assertions.assertTrue(account.getTransactions().getFirst().getAmount()==100);
        Assertions.assertTrue(account.getTransactions().getLast().getBalance()==800);
        Assertions.assertTrue(account.getTransactions().getLast().getAmount()==500);
    }

    @Test
    void should_add_transaction_when_withdraw_amount()  {
        account.deposit(500);
        account.withdraw(200);
        int size = account.getTransactions().size();
        Assertions.assertEquals(2, size);
        Assertions.assertTrue(account.getTransactions().getLast().getBalance()==300);
        Assertions.assertTrue(account.getTransactions().getLast().getAmount()==200);
    }

    @Test
    void should_print_all_operations() {
        account.deposit(1000);
        account.withdraw(200);
        account.deposit(2000);
        account.printStatements();
        Mockito.verify(printer).printStatement(account.getTransactions());


    }
}