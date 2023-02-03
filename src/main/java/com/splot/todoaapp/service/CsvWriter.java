package com.splot.todoaapp.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CsvWriter {
    private final static String BITCOIN = "BTC";
    private final static String ETHEREUM = "ETH";
    private final static String RIPPLE = "XRP";
    private final CryptoPriceService service;

    public CsvWriter(CryptoPriceService service) {
        this.service = service;
    }

    public void createCSVReport() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy_HH-mm-ss");
        String fileName = "report\\report_" + dtf.format(LocalDateTime.now()) + ".csv";
        try (FileWriter out = new FileWriter(fileName);
             CSVPrinter printer = new CSVPrinter(out,
                CSVFormat.DEFAULT.withHeader("Cryptocurrency Name", "Min Price", "Max Price"))) {
            printer.printRecord(BITCOIN, service.getLowestPriceByCryptocurrency(BITCOIN).getPrice(),
                service.getHighestPriceByCryptocurrency(BITCOIN).getPrice());
            printer.printRecord(ETHEREUM, service.getLowestPriceByCryptocurrency(ETHEREUM).getPrice(),
                service.getHighestPriceByCryptocurrency(ETHEREUM).getPrice());
            printer.printRecord(RIPPLE, service.getLowestPriceByCryptocurrency(RIPPLE).getPrice(),
                service.getHighestPriceByCryptocurrency(RIPPLE).getPrice());
        } catch (IOException e) {
            throw new RuntimeException ("Can't write new CSV report, check connection with DB!", e);
        }
    }
}
