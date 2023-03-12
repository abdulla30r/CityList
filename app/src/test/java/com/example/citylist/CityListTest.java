package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        City city1 = new City("AB","Dhaka");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size()); //total city thik ache kina
        assertTrue(cityList.getCities().contains(city)); //city ta asolei citylist e ache kina
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testDelete(){
        CityList cityList = new CityList();
        City city = new City("Jeshore","Khulna");
        City city1 = new City("Mirpur","Dhaka");
        cityList.add(city);
        cityList.add(city1);


        cityList.delete(city);
        assertTrue(!cityList.getCities().contains(city));
    }
}
