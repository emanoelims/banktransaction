package dev.emmanoel.banktransaction;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankStatementProcessorTest {

    @Test
    void shouldFilterBankTransactions() {
        final BankTransaction uber = new BankTransaction(LocalDate.parse("2022-01-14"), 39, "Uber");
        final BankTransaction shop = new BankTransaction(LocalDate.parse("2022-01-15"), 500, "Shop");
        final List<BankTransaction> bankTransactions = List.of(uber, shop);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        final List<BankTransaction> result = bankStatementProcessor
            .findTransactions(transaction ->
                transaction.getDescription().equals("Uber"));
        final List<BankTransaction> expect = List.of(uber);

        assertEquals(expect, result);
    }
}