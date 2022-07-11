package dev.emmanoel.banktransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionSimpleAnalyzer {
    private static final String RESOURCE = "src/main/resources/";
    private static final String FILE_NAME = "transactions.csv";

    public static void main(final String[] args) throws IOException {
        final Path path = Paths.get(RESOURCE + FILE_NAME);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }
        System.out.printf("The Total of all transactions is %.2f\n", total);

        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        total = 0d;
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            if (date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }
        System.out.printf("The Total of transactions in month January is %.2f\n", total);
    }
}
