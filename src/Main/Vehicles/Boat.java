package Main.Vehicles;

public class Boat extends MarineVehicle // قایق
{

    private String boatType ; // launch or lifeboat

    enum welfareServices // خدمات رفاهی
    {
        DRINK, SNACK
    }

    public Boat(double price, int capacity, int vehicleID, String manufacturerName, String fuelType,
                double minDepth, String boatType)
    {
        super(price, capacity, vehicleID, manufacturerName, fuelType, minDepth);
        this.boatType = boatType;
    }

    public String getBoatType() {
        return boatType;
    }

    public String getEnum()
    {
        welfareServices services1 = welfareServices.DRINK;
        welfareServices services2 = welfareServices.SNACK;
        return services1 + " " + services2 ;
    }

}
