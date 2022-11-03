package Main.Buildings;

import Main.Vehicles.MarineVehicle;

import java.util.ArrayList;

public class ShippingPort extends Terminal // بندر کشتیرانی
{
    public ArrayList<MarineVehicle> marineVehicles = new ArrayList<>() ; // لیست کشتی ها و قایق ها
    private int numPier ; // تعداد اسکله

    public ShippingPort(String type ,double constructionCost, String cityName, String terminalName, String address, double area,
                        int numVehicles, int numPier)
    {
        super(type ,constructionCost, cityName, terminalName, address, area, numVehicles);
        this.numPier = numPier;
    }
}
