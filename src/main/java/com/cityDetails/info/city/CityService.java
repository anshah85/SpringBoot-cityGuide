package com.cityDetails.info.city;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public void addNewCity(City city) {
        System.out.println(city);
        Optional<City> cityOptional = cityRepository.findCityByState(city.getCityState());
        if (cityOptional.isPresent()) {
            throw new IllegalStateException("State exists");
        }
        cityRepository.save(city);
    }

    public void deleteCity(Long cityId) {
        boolean exists = cityRepository.existsById(cityId);
        if (!exists) {
            throw new IllegalStateException("City not found");
        }
        cityRepository.deleteById(cityId);
    }

    @Transactional
    public void updateCity(Long cityId, String cityName, String cityState) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new IllegalStateException("City with cityId " + cityId + " does not exist"));

        if (cityName != null &&
                !cityName.isEmpty() &&
                !Objects.equals(city.getCityName(), cityName)) {
            city.setCityName(cityName);
        }

        if (cityState != null &&
                !cityState.isEmpty() &&
                !Objects.equals(city.getCityState(), cityState)) {
            Optional<City> cityOptional = cityRepository.findCityByState(cityState);
            if (cityOptional.isPresent()) {
                throw new IllegalStateException("State exists");
            }
            city.setCityState(cityState);
        }
    }
}
