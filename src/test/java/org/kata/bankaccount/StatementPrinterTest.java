package org.kata.bankaccount;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;

class StatementPrinterTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();



    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void should_print_record() {
        BankTransaction transaction = new Deposit(LocalDateTime.of(2022, 05, 20, 15, 30), 100, 200);
        String s = new StatementPrinter().printRecord(transaction);
        Assertions.assertEquals("Deposit   	| 2022-05-20	| 100	| 200", s);
    }

    @Test
    void should_print_statement() {
        BankTransaction deposit = new Deposit(LocalDateTime.of(2022, 05, 20, 15, 30), 1000, 2000);
        BankTransaction withdrawal = new Withdrawal(LocalDateTime.of(2022, 05, 21, 15, 30), 1000, 1000);
        List<BankTransaction> transactions = List.of(deposit, withdrawal);
        new StatementPrinter().printStatement(transactions);
        String expected = """
            Operation	| Date        	| Amount| Balance\r
            Deposit   	| 2022-05-20	| 1000	| 2000\r
            Withdrawal	| 2022-05-21	| 1000	| 1000""";
        Assertions.assertEquals(expected,
                outputStreamCaptor.toString().trim());

    }
}