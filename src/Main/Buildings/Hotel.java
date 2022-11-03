package Main.Buildings;

import Main.City;

import java.util.ArrayList;

public class Hotel
{
    private String name ; // نام هتل
    private double constructionCost ; // هزینه ساخت
    private String address ; // ادرس هتل
    private int numStar ; // تعداد ستاره ها
    private int numRoom ; // تعداد اتاق ها
    public ArrayList<HotelRoom> hotelRooms = new ArrayList<>() ; // لیست اتاق ها

    enum facilities // امکانات هتل
    {
        CAFE, POOL, GYM
    }

    public Hotel(String name, double constructionCost, String address, int numStar, int numRoom)
    {
        this.name = name;
        this.constructionCost = constructionCost;
        this.address = address;
        this.numStar = numStar;
        this.numRoom = numRoom;
    }

    public String getName() {
        return name;
    }

    public double getConstructionCost() {
        return constructionCost;
    }

    public String getAddress() {
        return address;
    }

    public int getNumStar() {
        return numStar;
    }

    public int getNumRoom() {
        return numRoom;
    }

    public String getEnum()
    {
        facilities facilities1 = facilities.CAFE;
        facilities facilities2 = facilities.GYM;
        facilities facilities3 = facilities.POOL;
        return facilities1 + " " + facilities2 + " " + facilities3 ;
    }

}
