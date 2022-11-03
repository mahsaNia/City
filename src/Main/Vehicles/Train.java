package Main.Vehicles;

public class Train extends LandVehicle // قطار
{
    private int numWagon ; // تعداد واگن
    private int numStar ; // تعداد ستاره

    enum welfareServices // خدمات رفاهی
    {
        CAFE, RESTAURANT
    }

    public Train(double price, int capacity, int vehicleID, String manufacturerName, String fuelType, double maxSpeed,
                 int numWagon, int numStar)
    {
        super(price, capacity, vehicleID, manufacturerName, fuelType, maxSpeed);
        this.numWagon = numWagon;
        this.numStar = numStar;
    }

    public String getEnum()
    {
        welfareServices services1 = welfareServices.CAFE;
        welfareServices services2 = welfareServices.RESTAURANT;
        return services1 + " " + services2 ;
    }

    public int getNumWagon() {
        return numWagon;
    }

    public int getNumStar() {
        return numStar;
    }

}
