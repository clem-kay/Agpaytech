package com.example.Country.resource;

import com.example.Country.model.Country;
import com.example.Country.model.Response;
import com.example.Country.service.impl.CountryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Objects;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/country")
@AllArgsConstructor
public class CountryResource {
    private final CountryServiceImpl countryService;

    @GetMapping("/list/{pageNo}/{size}")
    public ResponseEntity<Response> getCountries(@PathVariable("pageNo") int pageNo, @PathVariable("size") int size) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("countries", countryService.list(pageNo, size)))
                .message("Countries Retrieved")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCountry(@RequestBody @Valid Country country) {
        if (country.getName() == null) {
            return ResponseEntity.ok(Response.builder()
                    .timeStamp(now())
                    .message("Name of country cannot be null")
                    .status(BAD_REQUEST)
                    .statusCode(BAD_REQUEST.value())
                    .error("Empty Country")
                    .build()
            );

        } else {
            Country savedCountry = countryService.create(country);
            return ResponseEntity.ok(Response.builder()
                    .timeStamp(now())
                    .data(of("country", savedCountry == null ? "" : savedCountry))
                    .message(savedCountry == null ? "Duplicate Name found" : "New country created")
                    .status(savedCountry == null ? BAD_REQUEST : CREATED)
                    .statusCode(savedCountry == null ? BAD_REQUEST.value() : CREATED.value())
                    .error("")
                    .build()
            );
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteServer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("deleted", countryService.delete(id)))
                .message("country deleted")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getOne(@PathVariable("id") Long id) {
        Country foundCountry = countryService.get(id);
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("country", foundCountry == null ? "" : foundCountry))
                .message(foundCountry == null ? "No country found" : "country found")
                .status(foundCountry == null ? BAD_REQUEST : CREATED)
                .statusCode(foundCountry == null ? BAD_REQUEST.value() : CREATED.value())
                .error("")
                .build()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateCountry(@RequestBody @Valid Country country) {
        if (Objects.isNull(country)) {
            return ResponseEntity.ok(Response.builder()
                    .timeStamp(now())
                    .message("Empty country cannot be parsed")
                    .status(BAD_REQUEST)
                    .statusCode(BAD_REQUEST.value())
                    .error("Empty Country")
                    .build()
            );

        } else {
            return ResponseEntity.ok(Response.builder()
                    .timeStamp(now())
                    .data(of("country", countryService.update(country)))
                    .message(country.getName() + " updated")
                    .status(OK)
                    .statusCode(OK.value())
                    .build()
            );
        }

    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Response> searchByName(@PathVariable("name") String name) {
        if (name != null) {
            return ResponseEntity.ok(Response.builder()
                    .timeStamp(now())
                    .data(of("countries", countryService.search(name)))
                    .message("Country found")
                    .status(OK)
                    .statusCode(OK.value()).build()
            );
        } else {
            return ResponseEntity.ok(Response.builder()
                    .timeStamp(now())
                    .message("Empty Name")
                    .status(BAD_REQUEST)
                    .statusCode(BAD_REQUEST.value())
                    .error("Empty Name")
                    .build()
            );
        }

    }
}
