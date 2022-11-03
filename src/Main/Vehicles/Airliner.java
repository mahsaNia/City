package Main.Vehicles;

public class Airliner extends AirVehicle // هواپیما مسافربری
{

    private int numCabinCrew ; // تعداد خدمه
    private String classificationAircraftSeats ; // رده بندی صندلی

    enum welfareServices // خدمات رفاهی
    {
        DRINK, TV
    }

    public Airliner(double price, int capacity, int vehicleID, String manufacturerName, double maxHeight,
                    double airstripLength, int numCabinCrew, String classificationAircraftSeats)
    {
        super(price, capacity, vehicleID, manufacturerName, maxHeight, airstripLength);
        this.numCabinCrew = numCabinCrew;
        this.classificationAircraftSeats = classificationAircraftSeats;
    }

    public int getNumCabinCrew() {
        return numCabinCrew;
    }

    public String getClassificationAircraftSeats() {
        return classificationAircraftSeats;
    }

    public String getEnum()
    {
        welfareServices services1 = welfareServices.DRINK;
        welfareServices services2 = welfareServices.TV;
        return services1 + " " + services2 ;
    }

}
