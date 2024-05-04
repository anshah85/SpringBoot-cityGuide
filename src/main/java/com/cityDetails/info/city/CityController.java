package com.cityDetails.info.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getCities() {
        return cityService.getCities();
    }

    @PostMapping
    public void registerNewCity(@RequestBody City city) {
        cityService.addNewCity(city);
    }

    @DeleteMapping(path = "{cityId}")
    public void deleteCity(@PathVariable Long cityId) {
        cityService.deleteCity(cityId);
    }

    @PutMapping(path = "{cityId}")
    public void updateCity(@PathVariable Long cityId,
                           @RequestParam(required = false) String cityName,
                           @RequestParam(required = false) String cityState) {
        cityService.updateCity(cityId, cityName, cityState);
    }
}
