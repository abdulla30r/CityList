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

    /**
     * This test a city if added or not. Also check size of city list after adding a city is mathced or not
     */

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(0).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        City city1 = new City("AB","Dhaka");
        cityList.add(city);

        assertEquals(2, cityList.getCities(0).size());
        assertTrue(cityList.getCities(0).contains(city));
    }

    /**
     * This throw exception if city add fails
     */

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * This test city list sorted by default using city name
     */

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(0).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(1)));
    }

    /**
     * This test Delete method.
     */

    @Test
    public void testDelete(){
        CityList cityList = new CityList();
        City city = new City("Jeshore","Khulna");
        City city1 = new City("Mirpur","Dhaka");
        cityList.add(city);
        cityList.add(city1);


        cityList.delete(city);
        assertTrue(!cityList.getCities(0).contains(city));
    }

    /**
     * This test throw exception if item do not exist
     */

    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();
        City city = new City("Jeshore","Khulna");
        cityList.add(city);

        cityList.delete(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    /**
     * this test return return true if total number of item in city list is equal to the value of count() method
     */

    @Test
    public void testCount(){
        CityList cityList = new CityList();
        City city = new City("Jeshore","Khulna");
        City city1 = new City("Mirpur","Dhaka");
        cityList.add(city);
        cityList.add(city1);

        assertEquals(2,cityList.count());

        cityList.delete(city);
        assertEquals(1,cityList.count());

        cityList.delete(city1);
        assertEquals(0,cityList.count());
    }

    /**
     * This test check if the item in city list is sorted in order
     */

    @Test
    public void testSort(){
        CityList cityList = new CityList();
        City city = new City("Jeshore","Khulna");
        City city1 = new City("Mirpur","Dhaka");
        cityList.add(city);
        cityList.add(city1);

        assertEquals(0,city.compareTo(cityList.getCities(1).get(1)));
        assertEquals(0,city1.compareTo(cityList.getCities(1).get(0)));
    }
}
