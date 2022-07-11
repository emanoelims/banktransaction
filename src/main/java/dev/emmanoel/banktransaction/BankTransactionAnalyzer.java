package dev.emmanoel.banktransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzer {
    private static final String RESOURCE = "src/main/resources/";
    private static final String FILE_NAME = "transactions.csv";
    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    public static void main(final String[] args) throws IOException {
        final Path path = Paths.get(RESOURCE + FILE_NAME);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseFromCSV(lines);
        collectSummary(bankTransactions);
    }

    private static void collectSummary(List<BankTransaction> bankTransactions) {
        System.out.printf("The Total of all transactions is %.2f\n",
            calculateTotalAmount(bankTransactions));
        System.out.printf("The Total of transactions in month January is %.2f\n",
            calculateTotalAmountInMonth(bankTransactions, Month.JANUARY));
    }

    private static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    private static double calculateTotalAmountInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
}
