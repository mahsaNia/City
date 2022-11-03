package Main.Travel;

import Main.Buildings.Terminal;
import Main.Person;
import Main.Vehicles.Vehicle;

import java.util.ArrayList;

public class Travel implements Comparable
{
    private Terminal originTerminal; // ترمینال مبدا
    private Terminal destinationTerminal; // ترمینال مقصد
    private Person driver; // راننده
    private double travelCost; // هزینه سفر
    //تاریخ روز
    private int date;
    private int id;
    public static int countId = 1;
    private Vehicle vehicle; // وسیله نقلیه
    private ArrayList<Person> traveler; // لیست مسافران

    public Travel(Terminal originTerminal, Terminal destinationTerminal, Person driver, double travelCost, int date,
                   int id, Vehicle vehicle, ArrayList<Person> traveler)
    {
        countId++ ;
        this.originTerminal = originTerminal;
        this.destinationTerminal = destinationTerminal;
        this.driver = driver;
        this.travelCost = travelCost;
        this.date = date;
        this.id = id;
        this.vehicle = vehicle;
        this.traveler = traveler;
    }

    @Override
    public int compareTo(Object o)
    {
        Travel travel = (Travel) o ;
        if(this.date > travel.date)
            return 1 ;
        if(this.date < travel.date)
            return -1 ;
        else // برابر باشن
        {
            if(this.travelCost < travel.travelCost)
                return -1 ;
            if(this.travelCost > travel.travelCost)
                return 1 ;
        }
        return 0 ;
    }

    public Terminal getOriginTerminal() {
        return originTerminal;
    }

    public Terminal getDestinationTerminal() {
        return destinationTerminal;
    }

    public Person getDriver() {
        return driver;
    }

    public double getTravelCost() {
        return travelCost;
    }

    public int getDate() {
        return date;
    }


    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ArrayList<Person> getTraveler() {
        return traveler;
    }
}
