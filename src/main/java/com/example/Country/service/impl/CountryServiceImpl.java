package com.example.Country.service.impl;

import com.example.Country.model.Country;
import com.example.Country.repository.CountryRepository;
import com.example.Country.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Override
    public Country create(Country country) {
        log.info("saving a new country {}", country.getName());
        Optional<Country> countryFound = countryRepository.findCountryByName(country.getName());
        if (countryFound.isPresent()) {
            return null;
        } else {
            return countryRepository.save(country);
        }

    }

    @Override
    public List<Country> list(int pageNo, int limit) {
        log.info("Getting countries from {} with size {}", pageNo,limit);
        return countryRepository.findAll(PageRequest.of(pageNo, limit)).toList();
    }

    @Override
    public List<Country> search(String name) {
        log.info("Getting country by search {}",name);
        return countryRepository.searchByNameContaining(name);
    }

    @Override
    public Country get(Long id) {
        log.info("Getting country by id {}", id);
        Optional<Country> foundCountry = countryRepository.findById(id);
        return foundCountry.orElse(null);

    }

    @Override
    public Country update(Country country) {
        log.info("updating country {}", country.getName());
        return countryRepository.save(country);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("deleting country {}", id);
        countryRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
