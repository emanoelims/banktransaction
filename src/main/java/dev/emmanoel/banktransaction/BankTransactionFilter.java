package dev.emmanoel.banktransaction;

import java.util.List;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(List<BankTransaction> bankTransactions);
}
