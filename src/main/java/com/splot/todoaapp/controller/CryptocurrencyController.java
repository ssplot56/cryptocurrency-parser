package com.splot.todoaapp.controller;

import com.splot.todoaapp.dto.CryptoPriceResponseDto;
import com.splot.todoaapp.dto.mapper.CryptoPriceMapper;
import com.splot.todoaapp.service.CryptoPriceService;
import com.splot.todoaapp.service.CsvWriter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cryptocurrencies")
public class CryptocurrencyController {
    private final CryptoPriceService service;
    private final CryptoPriceMapper mapper;
    private final CsvWriter csvWriter;

    public CryptocurrencyController(CryptoPriceService service, CryptoPriceMapper mapper,
                                    CsvWriter csvWriter) {
        this.service = service;
        this.mapper = mapper;
        this.csvWriter = csvWriter;
    }

    @GetMapping("/minprice")
    public CryptoPriceResponseDto getMinCryptocurrencyByName(@RequestParam String name) {
        return mapper.toResponseDto(service.getLowestPriceByCryptocurrency(name.toUpperCase()));
    }

    @GetMapping("/maxprice")
    public CryptoPriceResponseDto getMaxCryptocurrencyByName(@RequestParam String name) {
        return mapper.toResponseDto(service.getHighestPriceByCryptocurrency(name.toUpperCase()));
    }

    @GetMapping
    public List<CryptoPriceResponseDto> getSortedCryptocurrenciesWithPagination(
            @RequestParam String name,
            @RequestParam Integer page,
            @RequestParam Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("price"));
        return service.getAllPriceByName(name, pageRequest).stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/csv")
    public String createCsvReport() {
        csvWriter.createCSVReport();
        return "Report was created";
    }
}
