package org.kata.bankaccount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest {

    @Test
    void should_update_balance_when_apply_deposit() {
        Deposit deposit = new Deposit(LocalDateTime.now()
                , 200
        , 1000);
        deposit.apply();
        Assertions.assertEquals(1200, deposit.getBalance());
    }
}