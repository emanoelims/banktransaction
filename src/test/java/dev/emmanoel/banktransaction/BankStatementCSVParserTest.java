package dev.emmanoel.banktransaction;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankStatementCSVParserTest {

    @Test
    void shouldParseOneCorrectLine() {
        final String line = "30-01-2017,-50,Tesco";
        final BankStatementParser bankStatementParser
            = new BankStatementCSVParser();
        final BankTransaction expect
            = new BankTransaction(LocalDate.parse("2017-01-30"), -50, "Tesco");
        final BankTransaction result = bankStatementParser.parseLineFrom(line);
        assertEquals(expect, result);
    }
}