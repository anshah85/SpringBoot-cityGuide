package com.cityDetails.info.city;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CityConfig {

    @Bean
    CommandLineRunner commandLineRunner(CityRepository cityRepository) {
        return args -> {
            City nyc = new City(
                    "New York City",
                    "NY",
                    LocalDate.of(1900, Month.JANUARY, 1)
            );

            City boston = new City(
                    "Boston",
                    "MA",
                    LocalDate.of(1924, Month.JANUARY, 1)
            );

            cityRepository.saveAll(
                    List.of(nyc, boston)
            );
        };
    }
}
