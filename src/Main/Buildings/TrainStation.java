package Main.Buildings;

import Main.Vehicles.Train;

import java.util.ArrayList;

public class TrainStation extends Terminal // ایستگاه راه آهن
{
    public ArrayList<Train> trains = new ArrayList<>() ; // لیست قطار ها
    private int numEntranceRails ; // تعداد ریل های ورودی
    private int numOutputRails ; // تعداد ریل های خروجی

    public TrainStation(String type ,double constructionCost, String cityName, String terminalName, String address, double area,
                        int numVehicles, int numEntranceRails, int numOutputRails)
    {
        super(type,constructionCost, cityName, terminalName, address, area, numVehicles);
        this.numEntranceRails = numEntranceRails;
        this.numOutputRails = numOutputRails;
    }
}
