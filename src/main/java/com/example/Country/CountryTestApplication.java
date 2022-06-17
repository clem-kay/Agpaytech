package com.example.Country;

import com.example.Country.model.Country;
import com.example.Country.repository.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CountryTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryTestApplication.class, args);
	}

	@Bean
	CommandLineRunner run (CountryRepository countryRepository) {
		return args -> {

			countryRepository.save(new Country(null,"India", 1313210000));
			countryRepository.save(new Country(null,"USA", 324666000));
			countryRepository.save(new Country(null,"Indonesia", 260581000));
			countryRepository.save(new Country(null,"Brazil", 207221000));
			countryRepository.save(new Country(null,"Pakistan", 196626000));
			countryRepository.save(new Country(null,"Nigeria", 186988000));
			countryRepository.save(new Country(null,"Bangladesh", 162099000));
			countryRepository.save(new Country(null,"Russia", 146838000));
			countryRepository.save(new Country(null,"Japan", 126830000));
			countryRepository.save(new Country(null,"Mexico", 122273000));
			countryRepository.save(new Country(null,"Philippines", 103738000));
			countryRepository.save(new Country(null,"Ethiopia", 101853000));
			countryRepository.save(new Country(null,"Vietnam", 92700000));
			countryRepository.save(new Country(null,"Egypt", 92641000));
			countryRepository.save(new Country(null,"Germany", 82800000));
			countryRepository.save(new Country(null,"the Congo", 82243000));
			countryRepository.save(new Country(null,"Iran", 82800000));
			countryRepository.save(new Country(null,"Turkey", 79814000));
			countryRepository.save(new Country(null,"Thailand", 68147000));
			countryRepository.save(new Country(null,"France", 66984000));
			countryRepository.save(new Country(null,"United Kingdom", 60589000));
			countryRepository.save(new Country(null,"South Africa", 55908000));
			countryRepository.save(new Country(null,"Myanmar", 51446000));
			countryRepository.save(new Country(null,"South Korea", 68147000));
			countryRepository.save(new Country(null,"Colombia", 49129000));
			countryRepository.save(new Country(null,"Kenya", 47251000));
			countryRepository.save(new Country(null,"Spain", 46812000));
			countryRepository.save(new Country(null,"Argentina", 43850000));
			countryRepository.save(new Country(null,"Ukraine", 42603000));
			countryRepository.save(new Country(null,"Sudan", 41176000));
			countryRepository.save(new Country(null,"Algeria", 40400000));
			countryRepository.save(new Country(null,"Poland", 38439000));
			countryRepository.save(new Country(null,"Canada", 37742154));
			countryRepository.save(new Country(null,"Morocco", 36910560));
			countryRepository.save(new Country(null,"Saudi Arabia", 34813871));
			countryRepository.save(new Country(null,"Uzbekistan", 33469203));
			countryRepository.save(new Country(null,"Peru", 32971854));
			countryRepository.save(new Country(null,"Angola", 32866272));
			countryRepository.save(new Country(null,"Malaysia", 32365999));
			countryRepository.save(new Country(null,"Mozambique", 31255435));
			countryRepository.save(new Country(null,"Ghana", 31072940));
			countryRepository.save(new Country(null,"Yemen", 29825964));
			countryRepository.save(new Country(null,"Nepal", 29136808));
			countryRepository.save(new Country(null,"Venezuela", 28435940));
		};
	}
}

