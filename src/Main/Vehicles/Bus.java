package Main.Vehicles;

public class Bus extends LandVehicle // اتوبوس
{
    private String dimensions ; // ابعاد . large. Medium

    enum welfareServices // خدمات رفاهی
    {
        SNACK, TV
    }

    public Bus(double price, int capacity, int vehicleID, String manufacturerName, String fuelType,
               double maxSpeed, String dimensions)
    {
        super(price, capacity, vehicleID, manufacturerName, fuelType, maxSpeed);
        this.dimensions = dimensions;
    }

    public String getDimensions() {
        return dimensions;
    }

    public String getEnum()
    {
        welfareServices services1 = welfareServices.SNACK;
        welfareServices services2 = welfareServices.TV;
        return services1 + " " + services2 ;
    }

}
