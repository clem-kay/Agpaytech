package com.example.Country.service;

import com.example.Country.model.Country;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CountryService {
    Country create(Country flag);
    List<Country> list(int pageNo, int size);
    Country get(Long id);
    Country update(Country server);
    Boolean delete(Long id);
}
