package com.example.Country.service.impl;

import com.example.Country.model.Country;
import com.example.Country.model.Response;
import com.example.Country.repository.CountryRepository;
import com.example.Country.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

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
            throw new IllegalArgumentException("Duplicate country name found");
        } else {
            return countryRepository.save(country);
        }

    }

    @Override
    public List<Country> list(int pageNo, int limit) {
        log.info("Getting countries from {}", pageNo + "with size {}", limit);
        return countryRepository.findAll(PageRequest.of(pageNo, limit)).toList();
    }

    @Override
    public List<Country> search(String name) {
        log.info("Getting country by serach {}",name);
        return countryRepository.searchByName(name);
    }

    @Override
    public Country get(Long id) {
        log.info("Getting country by id {}", id);
        return countryRepository.findById(id).get();
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
