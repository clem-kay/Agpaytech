package com.example.Country.service;

import com.example.Country.model.Country;

import java.util.List;

public interface CountryService {
    Country create(Country flag);
    List<Country> list(int pageNo, int size);
    List<Country> search(String name);
    Country get(Long id);
    Country update(Country server);
    Boolean delete(Long id);
}
