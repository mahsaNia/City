package Main.Travel;

import Main.Buildings.Terminal;
import Main.Person;
import Main.Vehicles.Vehicle;

import java.util.ArrayList;

public interface Travelable // واسط سفربل
{

    void newTravel(Terminal originTerminal, Terminal destinationTerminal, Person driver, double travelCost, int date
                   , Vehicle vehicle, ArrayList<Person> traveler); // سفر جدید

    void travelSorting(); // مرتب سازی سفر

    double calculateTravelCost(ArrayList<Person> traveler, Vehicle vehicle); // محاسبه هزینه سفر

    void  travelHistory(Terminal terminal, boolean input, boolean output) ; // تاریخچه سفرها



}
