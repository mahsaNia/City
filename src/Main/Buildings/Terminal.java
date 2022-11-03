package Main.Buildings;

import Main.Country;
import Main.Person;
import Main.Travel.Travel;
import Main.Travel.Travelable;
import Main.Vehicles.Vehicle;

import java.util.ArrayList;

abstract public class Terminal implements Travelable // ترمینال ها
{
    private String type;
    private double constructionCost ; //هزینه ساخت
    private String cityName ; // نام شهر
    private String terminalName ; // نام ترمینال
    private String address ; // آدرس
    private double area ; // متراژ
    private int numVehicles ; // تعداد وسایل نقلیه
    public ArrayList<Person> people = new ArrayList<>(); // لیست راهبران
    public ArrayList<Vehicle> terminalVehicles = new ArrayList<>(); // لیست وسایل نقلیه
    public ArrayList<Travel> incomingTrips = new ArrayList<>(); // لیست سفرهای ورودی
    public ArrayList<Travel> outputTrips = new ArrayList<>(); // لیست سفرهای خروجی

    public Terminal(String type ,double constructionCost, String cityName, String terminalName, String address,
                    double area, int numVehicles)
    {
        this.type = type;
        this.constructionCost = constructionCost;
        this.cityName = cityName;
        this.terminalName = terminalName;
        this.address = address;
        this.area = area;
        this.numVehicles = numVehicles;
    }

    public double getConstructionCost() {
        return constructionCost;
    }

    public String getCityName() {
        return cityName;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    public int getNumVehicles() {
        return numVehicles;
    }

    public String getType() {
        return type;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    @Override
    public void newTravel(Terminal originTerminal, Terminal destinationTerminal, Person driver, double travelCost,
                          int date, Vehicle vehicle, ArrayList<Person> traveler)
    {
        int id = Travel.countId ;
        Travel travel = new Travel(originTerminal, destinationTerminal, driver, travelCost, date, id, vehicle,
                traveler);
        originTerminal.outputTrips.add(travel); // اد کردن به لیست سفر های خروجی ترمینال مبدا
        destinationTerminal.incomingTrips.add(travel); // اد کردن به لیست سفر های ورودی ترمینال مقصد

        //***********************
        for (int i = 0; i < originTerminal.people.size(); i++)
        {
            if(originTerminal.people.get(i).getPersonID() == driver.getPersonID())
            {
                originTerminal.people.remove(i); // حذف راننده از ترمینال مبدا
                break;
            }
        }

        //********************

                destinationTerminal.people.add(driver); // اضافه کردن راننده به ترمینال مقصد


        //*********************
        for (int i = 0; i < originTerminal.terminalVehicles.size(); i++)
        {
            if(originTerminal.terminalVehicles.get(i).getVehicleID() == vehicle.getVehicleID())
            {
                originTerminal.terminalVehicles.remove(i); // حذف وسیله نقلیه از ترمینال مبدا
                break;
            }
        }

        //*********************

                destinationTerminal.terminalVehicles.add(vehicle); // اضافه کردن وسیله نقلیه به ترمینال مقصد

        //***********************
        String originCity = originTerminal.cityName;
        String destinationCity = destinationTerminal.cityName;

        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals(originCity))
            {
                for (int j = 0; j < Country.cities.get(i).people.size(); j++)
                {
                    for (int k = 0; k < traveler.size(); k++)
                    {
                        if (Country.cities.get(i).people.get(j).getPersonID() == traveler.get(k).getPersonID())
                        {
                            Country.cities.get(i).people.remove(j); // حذف مسافر از لیست شهروندان مبدا
                            Country.cities.get(i).setPopulation(Country.cities.get(i).getPopulation() - 1);
                            break;
                        }
                    }

                }
            }
        }
        //**************************************************

        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals(destinationCity))
            {
              for (int k = 0; k < traveler.size(); k++)
              {
                  Country.cities.get(i).people.add(traveler.get(k)); // اضافه کردن مسافر به لیست شهروندان مقصد
              }
            }
        }
        //**************************************************


        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals(originCity))
            {
                for (int j = 0; j < Country.cities.get(i).people.size(); j++)
                {
                    if (Country.cities.get(i).people.get(j).getPersonID() == driver.getPersonID())
                    {
                        Country.cities.get(i).people.remove(j); // حذف راننده از لیست شهروندان مبدا
                        break;
                    }
                }
            }
        }
        //*********************************************


        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals(destinationCity))
            {
                Country.cities.get(i).people.add(driver); // اضافه کردن رانننده به لیست شهروندان مقصد
                break;
            }
        }
        //****************************************
    }

    @Override
    public void travelSorting()
    {
        for (int i = 0; i < incomingTrips.size(); i++)
        {
            for (int j = i + 1; j < incomingTrips.size(); j++)
            {
               if (incomingTrips.get(j).compareTo(incomingTrips.get(i)) < 0)
               {
                   Travel t = incomingTrips.get(j);
                   incomingTrips.set(j, incomingTrips.get(i));
                   incomingTrips.set(i, t);
               }
            }
        }

        for (int i = 0; i < outputTrips.size(); i++)
        {
            for (int j = i + 1; j < outputTrips.size(); j++)
            {
                if (outputTrips.get(j).compareTo(outputTrips.get(i)) < 0)
                {
                    Travel t = outputTrips.get(j);
                    outputTrips.set(j, outputTrips.get(i));
                    outputTrips.set(i, t);
                }
            }
        }

    }

    @Override
    public double calculateTravelCost(ArrayList<Person> traveler, Vehicle vehicle)
    {
        double cost = 0;
        for (int i = 0; i < traveler.size(); i++)
        {
            cost = cost + traveler.get(i).getEmploymentSalary();
        }
        cost = cost + vehicle.getPrice();
        return cost;
    }

    @Override
    public void travelHistory(Terminal terminal, boolean input, boolean output)
    {
        if(input && !output)
        {
            System.out.println(" incoming trips list :");
            for (int i = 0; i < terminal.incomingTrips.size(); i++)
            {
                System.out.println(" terminal name: " + terminal.terminalName + "  driver:" +
                        terminal.incomingTrips.get(i).getDriver().getPersonID() + "   travel cost: " +
                        terminal.incomingTrips.get(i).getTravelCost() + "   id: " +
                        terminal.incomingTrips.get(i).getId() + "   date: " + terminal.incomingTrips.get(i).getDate());
                System.out.println();
            }
        }
        else if(output && !input)
        {
            System.out.println(" output trips list :");
            for (int i = 0; i < terminal.outputTrips.size(); i++)
            {
                System.out.println(" terminal name: " + terminal.terminalName + "  driver:" +
                        terminal.outputTrips.get(i).getDriver().getPersonID() + "   travel cost: " +
                        terminal.outputTrips.get(i).getTravelCost() + "   id: " +
                        terminal.outputTrips.get(i).getId() + "   date: " + terminal.outputTrips.get(i).getDate());
                System.out.println();
            }
        }
        else if(output && input)
        {
            System.out.println(" incoming trips list :");
            for (int i = 0; i < terminal.incomingTrips.size(); i++)
            {
                System.out.println(" terminal name: " + terminal.terminalName + "  driver:" +
                        terminal.incomingTrips.get(i).getDriver().getPersonID() + "   travel cost: " +
                        terminal.incomingTrips.get(i).getTravelCost() + "   id: " +
                        terminal.incomingTrips.get(i).getId() + "   date: " + terminal.incomingTrips.get(i).getDate());
                System.out.println();
            }
            System.out.println("------------------------------------------------------------------------");

            System.out.println(" output trips list :");
            for (int i = 0; i < terminal.outputTrips.size(); i++)
            {
                System.out.println(" terminal name: " + terminal.terminalName + "  driver:" +
                        terminal.outputTrips.get(i).getDriver().getPersonID() + "   travel cost: " +
                        terminal.outputTrips.get(i).getTravelCost() + "   id: " +
                        terminal.outputTrips.get(i).getId() + "   date: " + terminal.outputTrips.get(i).getDate());
                System.out.println();
            }
        }

    }
}
