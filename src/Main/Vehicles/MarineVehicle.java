package Main.Vehicles;

abstract public class MarineVehicle extends Vehicle // وسیله نقلیه دریایی
{

    private String fuelType ; // نوع سوخت
    private double minDepth ; // حداقل عمق

    public MarineVehicle(double price, int capacity, int vehicleID, String manufacturerName,
                         String fuelType, double minDepth)
    {
        super(price, capacity, vehicleID, manufacturerName);
        this.fuelType = fuelType;
        this.minDepth = minDepth;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getMinDepth() {
        return minDepth;
    }
}
