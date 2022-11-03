package Main;

import Main.Buildings.Hotel;
import Main.Buildings.Terminal;

import java.util.ArrayList;

public class City
{

    private int population = 0 ;
    private double totalBudget ;
    private String cityName ; // نام شهر
    public ArrayList<Person> people = new ArrayList<>() ;
    public ArrayList<Terminal> terminals = new ArrayList<>();
    public ArrayList<Hotel> hotels = new ArrayList<>();

    public City(int population, double totalBudget, String cityName)
    {
        this.population = population;
        this.totalBudget = totalBudget;
        this.cityName = cityName;
    }

    public int getPopulation() {
        return population;
    }

    public double getTotalBudget() {
        return totalBudget;
    }

    public String getCityName() {
        return cityName;
    }

    public boolean spendBudget(double price)
    {
        if(price <= this.totalBudget)
        {
            this.totalBudget = this.totalBudget - price;
            return true;
        }
        else
        {
            System.out.println("\tnot enough budget !");
            return false;
        }
    }

    public void addCitizen(ArrayList<Person> people)
    {
        this.people = people;
    }

    public void addPopulation(int numPerson)
    {
        population = population + numPerson;
        Country.totalCountryPopulation = Country.totalCountryPopulation + numPerson;
    }

    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
