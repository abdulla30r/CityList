package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This delete a city from the city list if city exist
     * @param city
     *        This is the city to delete
     */

    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This return a sorted list of city according to option
     * @param option
     *          option is used to distinguish between different sorting style. such that 0 for sort by city name else for province name
     * @return city list (sorted)
     */
    public List<City> getCities(int option) {
        List<City> cityList = cities;

        if (option == 0){
            Collections.sort(cityList);
        }
        else{
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City o1, City o2) {
                     return o1.getProvinceName().compareTo(o2.getProvinceName());
                }
            });
        }
        return cityList;
    }

    /**
     * This function gives us the count or size of city list
     * @return city list size
     */

    public int count() {
        return cities.size();
    }
}
