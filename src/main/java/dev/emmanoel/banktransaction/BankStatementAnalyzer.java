package dev.emmanoel.banktransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCE = "src/main/resources/";

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.printf("The Total of all transactions is %.2f\n",
            bankStatementProcessor.calculateTotalAmount());
        System.out.printf("The Total of transactions in month January is %.2f\n",
            bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.printf("The Total of transactions in February is %.2f\n",
            bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.printf("The Total of salary is %.2f\n",
            bankStatementProcessor.calculateTotalForCategory("Salary"));
    }

    public void analyzer(String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCE + fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }
}
