package dev.emmanoel.banktransaction;

import java.io.IOException;

public class MainApplication {

    private static final String FILE_NAME = "transactions.csv";

    public static void main(String[] args) throws IOException {

        final BankStatementAnalyzer bankStatementAnalyzer
            = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser
            = new BankStatementCSVParser();
        bankStatementAnalyzer.analyzer(FILE_NAME, bankStatementParser);
    }
}
