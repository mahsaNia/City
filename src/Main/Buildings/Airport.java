package Main.Buildings;

import Main.Person;
import Main.Vehicles.AirVehicle;
import Main.Vehicles.Vehicle;

import java.util.ArrayList;

public class Airport extends Terminal // فرودگاه
{

    public ArrayList<AirVehicle> airVehicles = new ArrayList<>() ; // لیست وسایل نقلیه هوایی
    private boolean airportType ; // نوع فرودگاه(فرودگاه بین المللی نوع تورو دارد)
    private int numRunway ; // تعداد باند پرواز

    public Airport(String type ,double constructionCost, String cityName, String terminalName, String address, double area,
                   int numVehicles, boolean airportType, int numRunway)
    {
        super(type ,constructionCost, cityName, terminalName, address, area, numVehicles);
        this.airportType = airportType;
        this.numRunway = numRunway;
    }
}
