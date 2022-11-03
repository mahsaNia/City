package Main.Vehicles;

abstract public class AirVehicle extends Vehicle // وسیله نقلیه هوایی
{

    private double maxHeight ; // حداکثر ارتفاع پرواز
    private double airstripLength ; // طول باند فرود

    public AirVehicle(double price, int capacity, int vehicleID, String manufacturerName,
                      double maxHeight, double airstripLength)
    {
        super(price, capacity, vehicleID, manufacturerName);
        this.maxHeight = maxHeight;
        this.airstripLength = airstripLength;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public double getAirstripLength() {
        return airstripLength;
    }

}
