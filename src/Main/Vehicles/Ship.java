package Main.Vehicles;

public class Ship  extends MarineVehicle // کشتی
{
    private String dimensions ; // ابعاد . large. Medium

    enum welfareServices // خدمات رفاهی
    {
        RESTAURANT, POOL, GYM, CAFE
    }

    public Ship(double price, int capacity, int vehicleID, String manufacturerName, String fuelType,
                double minDepth,  String dimensions)
    {
        super(price, capacity, vehicleID, manufacturerName, fuelType, minDepth);
        this.dimensions = dimensions;
    }

    public String getDimensions() {
        return dimensions;
    }

    public String getEnum()
    {
        welfareServices services1 = welfareServices.CAFE;
        welfareServices services2 = welfareServices.GYM;
        welfareServices services3 = welfareServices.POOL;
        welfareServices services4 = welfareServices.RESTAURANT;
        return services1 + " " + services2 + " " + services3 + " " + services4 ;
    }

}
