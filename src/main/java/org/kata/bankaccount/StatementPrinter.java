package org.kata.bankaccount;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

public class StatementPrinter {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public String printRecord(BankTransaction transaction){

        StringBuilder sb = new StringBuilder();
        sb.append(transaction.getOperationType().getValue()).append(
                "\t| ").append((transaction.getDate()).format(formatter)).append("\t| ").append(transaction.getAmount()).append("\t| ").append(transaction.getBalance());

        return sb.toString();
    }

    public void printStatement(Collection<BankTransaction> transactions){
        StringBuilder header =
                new StringBuilder("Operation").append("\t").append("| Date        ").append("\t").append("| Amount").append("| Balance");
        System.out.println(header);
        transactions.stream().map( record -> printRecord(record)).forEach(System.out::println);
    }
}
