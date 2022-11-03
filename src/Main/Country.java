package Main;

import java.util.ArrayList;

public class Country
{
    public static String name = "Iran" ;
    public static ArrayList<City> cities = new ArrayList<>();
    public static int totalCountryPopulation; // جمعیت کل
    public static double totalCountryBudget; // بودجه کل

    public static void addNewCity(City city, double budget) // افزودن شهر جدید
    {
        cities.add(city);
        totalCountryBudget = totalCountryBudget + budget;
    }

    public static void CityInformation(String cityName) // قابلیت دسترسی به شهرها و چاپ اطلاعات
    {
        for (int i = 0; i < cities.size(); i++)
        {
            if (cities.get(i).getCityName().equals(cityName))
            {
                System.out.println(" city name: " + cities.get(i).getCityName() +
                        "   total budget: " + cities.get(i).getTotalBudget() +
                        "   population: " + cities.get(i).getPopulation());
                break;
            }
        }
    }



}
