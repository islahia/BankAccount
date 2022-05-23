package org.kata.bankaccount;

import lombok.Getter;

public enum OperationType {

    DEPOSIT("Deposit   "),
    WITHDRAWAL("Withdrawal");

    @Getter
    String value;

    OperationType(String value) {
        this.value = value;
    }
}
