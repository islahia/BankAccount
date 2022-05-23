package org.kata.bankaccount;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Account {


    StatementPrinter statementPrinter;

    @Getter
    private final Deque<BankTransaction> transactions;



    public Account(StatementPrinter printer) {
        statementPrinter = printer;
        transactions = new LinkedList<>();
    }

    synchronized public void deposit(int amount)  {
        int balance = getBalance();
        BankTransaction deposit = new Deposit(LocalDateTime.now(),
                amount, balance);
        deposit.apply();
        transactions.add(deposit);
    }

    synchronized  public void withdraw(int amount) {
        int balance = getBalance();
        BankTransaction withdrawal = new Withdrawal(LocalDateTime.now()
                , amount, balance);
        withdrawal.apply();
        transactions.add(withdrawal);
    }

    private int getBalance() {
        return transactions.size() == 0 ? 0 :
                transactions.getLast().getBalance();
    }

    public void printStatements() {
        statementPrinter.printStatement(transactions);
    }
}
