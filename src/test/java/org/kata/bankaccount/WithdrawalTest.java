package org.kata.bankaccount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class WithdrawalTest {

    @Test
    void should_update_balance_when_apply_withdrawal() {
        Withdrawal withdrawal =
                new Withdrawal(LocalDateTime.now(), 200,
                        1000);
        withdrawal.apply();
        Assertions.assertEquals(800,
                withdrawal.getBalance());
    }
}