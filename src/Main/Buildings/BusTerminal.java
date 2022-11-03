package Main.Buildings;

import Main.Vehicles.Bus;

import java.util.ArrayList;

public class BusTerminal extends Terminal // پایانه اتوبوسرانی
{
    public ArrayList<Bus> buses = new ArrayList<>() ; // لیست اتوبوس ها

    public BusTerminal(String type,double constructionCost, String cityName, String terminalName, String address,
                       double area, int numVehicles)
    {
        super(type,constructionCost, cityName, terminalName, address, area, numVehicles);
    }
}
