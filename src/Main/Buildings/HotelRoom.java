package Main.Buildings;

public class HotelRoom
{
    private int roomNumber ; // شماره اتاق
    private int numBed ; // تعداد تخت
    private double area ; // متراژ
    private double roomPrice ; // قیمت اقامت

    public HotelRoom(int roomNumber, int numBed, double area, double roomPrice)
    {
        this.roomNumber = roomNumber;
        this.numBed = numBed;
        this.area = area;
        this.roomPrice = roomPrice;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNumBed() {
        return numBed;
    }

    public double getArea() {
        return area;
    }

    public double getRoomPrice() {
        return roomPrice;
    }
}
