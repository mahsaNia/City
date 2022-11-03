package Main.Vehicles;

import Main.City;

public class CargoPlane extends AirVehicle // هواپیما باربری
{
    private double maxWeight ; // حداکثر وزن قابل حمل هواپیما

    public CargoPlane(double price, int capacity, int vehicleID, String manufacturerName, double maxHeight,
                      double airstripLength, double maxWeight)
    {
        super(price, capacity, vehicleID, manufacturerName, maxHeight, airstripLength);
        this.maxWeight = maxWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

}
