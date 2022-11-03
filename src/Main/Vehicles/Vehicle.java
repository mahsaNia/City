package Main.Vehicles;

abstract public class Vehicle // وسایل نقلیه
{
    private double price ; // قیمت خرید
    private int capacity ; // ظرفیت
    private int vehicleID ; // آیدی
    public static int id = 1 ;
    private String ManufacturerName ; // نام شرکت سازنده

    public Vehicle(double price, int capacity, int vehicleID, String manufacturerName)
    {
        id++ ;
        this.price = price;
        this.capacity = capacity;
        this.vehicleID = vehicleID;
        ManufacturerName = manufacturerName;
    }

    public double getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public String getManufacturerName() {
        return ManufacturerName;
    }

}
