package Main.Vehicles;

 public abstract class LandVehicle extends Vehicle // وسیله نقلیه زمینی
{

    private String fuelType ; // نوع سوخت
    private double maxSpeed ; // حداکثر سرعت

    public LandVehicle(double price, int capacity, int vehicleID, String manufacturerName, String fuelType
            , double maxSpeed)
    {
        super(price, capacity, vehicleID, manufacturerName);
        this.fuelType = fuelType;
        this.maxSpeed = maxSpeed;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

}
