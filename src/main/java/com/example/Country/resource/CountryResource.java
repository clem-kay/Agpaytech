package com.example.Country.resource;

import com.example.Country.model.Country;
import com.example.Country.model.Response;
import com.example.Country.service.impl.CountryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/country")
@AllArgsConstructor
public class CountryResource {
    private final CountryServiceImpl countryService;

    @GetMapping("/list/{pageNo}/{size}")
    public ResponseEntity<Response> getServers(@PathVariable int pageNo, @PathVariable int size) {
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

        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("country", countryService.create(country)))
                .message("New country created")
                .status(CREATED)
                .statusCode(CREATED.value())
                .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getServer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("country", countryService.get(id)))
                .message("country retrieved")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
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
}
