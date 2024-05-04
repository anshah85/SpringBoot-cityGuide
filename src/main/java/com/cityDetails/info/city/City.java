package com.cityDetails.info.city;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class City {
    @Id
    @SequenceGenerator(
            name = "city_sequence",
            sequenceName = "city_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "city_sequence"
    )
    private Long cityId;
    private String cityName;
    private String cityState;
    private LocalDate yob;
    @Transient
    private Integer age;

    public City() {
    }

    public City(Long cityId, String cityName, String cityState, LocalDate yob) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityState = cityState;
        this.yob = yob;
    }

    public City(String cityName, String cityState, LocalDate yob) {
        this.cityName = cityName;
        this.cityState = cityState;
        this.yob = yob;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityState() {
        return cityState;
    }

    public void setCityState(String cityState) {
        this.cityState = cityState;
    }

    public LocalDate getYob() {
        return yob;
    }

    public void setYob(LocalDate yob) {
        this.yob = yob;
    }

    public Integer getAge() {
        return Period.between(this.yob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", cityState='" + cityState + '\'' +
                ", yob=" + yob +
                ", age=" + age +
                '}';
    }
}
