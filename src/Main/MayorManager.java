package Main;

import Main.Buildings.*;
import Main.Exceptions.*;
import Main.Vehicles.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MayorManager
{
    Scanner input = new Scanner(System.in);

    public void buildCapital()
    {
        City capital = new City(0, 10000,"tehran");

        int personID = Person.id;
        capital.people.add(new Person(personID ,"Mahsa", "Niazi", "80",
                "Isfahan", "sailor", "female", 75));

        personID = Person.id;
        capital.people.add(new Person(personID,"Saeed", "Saei", "60",
                "Kish", "sailor", "male", 75));

        personID = Person.id;
        capital.people.add(new Person(personID,"Sepehr", "Tavasoli", "50",
                "Tehran", "pilot", "male", 90));

        personID = Person.id;
        capital.people.add(new Person(personID,"Zahra", "Ziaei", "61",
                "Tabriz", "pilot", "female", 90));

        personID = Person.id;
        capital.people.add(new Person(personID,"Ali" , "Jamshidy", "43",
                "Gilan", "bus driver", "male", 50));

        personID = Person.id;
        capital.people.add(new Person(personID,"Pouria", "Sadeghi", "41",
                "Kerman", "bus driver", "male", 50));

        personID = Person.id;
        capital.people.add(new Person(personID,"Mehrad", "Yeganeh", "63",
                "Shiraz", "engine driver", "male", 65));

        personID = Person.id;
        capital.people.add(new Person(personID,"Reza", "Akbari", "40",
                "Tehran", "engine driver", "male", 65));

        personID = Person.id;
        capital.people.add(new Person(personID,"Asal", "Mohammadi", "76",
                "Kish", "crewman", "female", 48));

        personID = Person.id;
        capital.people.add(new Person(personID,"Mahdi", "Naseri", "65",
                "Gheshm", "crewman", "male", 48));

        personID = Person.id;
        capital.people.add(new Person(personID,"Parisa", "Poorian", "74",
                "Isfahan", "crewman", "female", 48));

        capital.addPopulation(capital.people.size());
        Country.addNewCity(capital, capital.getTotalBudget());
    }

    public void mayorMenu1()
    {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("\t*** Hello Mayor ! What do you want to do? ***");
        System.out.println(" 1) Build a new city\n 2) Enter the city\n 3) show information of all cities\n" +
                " 4) show information of a city\n 5) log out");

        System.out.print("\tEnter your choice ----> ");
        int mayorChoice = input.nextInt() ;
        mayorMenu2(mayorChoice);
    }

    public void mayorMenu2(int mayorChoice)
    {

        switch (mayorChoice)
        {
            case 1 : // Build a new city
            {
                System.out.print(" 1) population: "); int population = input.nextInt();
                System.out.print(" 2) total budget: "); double budget = input.nextDouble();
                System.out.print(" 3) city name: "); String cityName = input.next();
                City newCity = new City(population, budget, cityName);
                Country.addNewCity(newCity, budget);
                mayorMenu1();
                break;
            }

            case 2 : // Enter the city
            {
                System.out.print(" Enter the name of city: "); String cityName = input.next();
                System.out.println("--------------------------------------------------------------------");
                System.out.println(" 1) build a terminal\n 2) buy a vehicle\n 3) hire a driver\n 4) build hotel\n" +
                        " 5) build hotel room\n 6) show terminal information\n 7) show hotel information\n" +
                        " 8) add trip\n 9) show trips\n 10) back");
                System.out.print(" Enter a number: "); int num = input.nextInt();
                switch (num)
                {
                    case 1 : // build a terminal
                    {
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println(" 1) build airport\n 2) build bus terminal\n 3) build shipping port\n" +
                                " 4) build train station\n 5) back to main menu");
                        System.out.print(" Enter a number: "); int num1 = input.nextInt();
                        buildTerminal(cityName, num1);
                        mayorMenu1();
                        break;
                    }

                    case 2: // buy a vehicle
                    {
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println(" 1) buy bus\n 2) buy ship\n 3) buy boat\n 4) buy airliner\n" +
                                " 5) buy cargo plane\n 6) buy train\n 7) back to main menu");
                        System.out.print(" Enter a number: "); int num1 = input.nextInt();
                        buyVehicle(cityName, num1);
                        mayorMenu1();
                        break;
                    }

                    case 3 : // hire a driver
                    {
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println(" 1) sailor\n 2) pilot\n 3) bus driver\n 4) engine driver\n" +
                                " 5) crewman\n 6) back to main menu");
                        System.out.print(" Enter a number: "); int num1 = input.nextInt(); input.nextLine();
                        hireDriver(cityName, num1);
                        mayorMenu1();
                        break;
                    }

                    case 4: // build hotel
                    {
                        System.out.println("--------------------------------------------------------------------");
                        buildHotel(cityName);
                        mayorMenu1();
                        break;
                    }

                    case 5 : // build hotel room
                    {
                        System.out.println("--------------------------------------------------------------------");
                        buildRoom(cityName);
                        mayorMenu1();
                        break;
                    }

                    case 6 : // show terminal information
                    {
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" terminals : ");
                        for (int i = 0; i < Country.cities.size(); i++)
                        {
                            if (Country.cities.get(i).getCityName().equals(cityName))
                            {
                                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                                {
                                    System.out.println(" terminal name: " + Country.cities.get(i).terminals.get(j)
                                            .getTerminalName() + "   address: " + Country.cities.get(i).terminals
                                            .get(j).getAddress() + "   area: " + Country.cities.get(i).terminals
                                            .get(j).getArea() + "   number of vehicles: " + Country.cities.get(i)
                                            .terminals.get(j).terminalVehicles.size());

                                    System.out.println(" vehicles: ");
                                    for (int k = 0; k < Country.cities.get(i).terminals.get(j).terminalVehicles.size(); k++)
                                    {
                                        System.out.println(" id: " +  Country.cities.get(i).terminals.get(j)
                                                .terminalVehicles.get(k).getVehicleID() + "   capacity: " +
                                                Country.cities.get(i).terminals.get(j).terminalVehicles.get(k).getCapacity()
                                        + "   price: " +  Country.cities.get(i).terminals.get(j).terminalVehicles.get(k)
                                                .getPrice() + "    manufacturer name: " +
                                                Country.cities.get(i).terminals.get(j).terminalVehicles.get(k).getManufacturerName());
                                    }

                                    System.out.println(" drivers: ");
                                    for (int l = 0; l < Country.cities.get(i).terminals.get(j).people.size(); l++)
                                    {
                                        System.out.println(" name: " + Country.cities.get(i).terminals.get(j).people
                                                .get(l).getName() + "  " + Country.cities.get(i).terminals.get(j).people
                                                .get(l).getLastName() + "   job: " + Country.cities.get(i).terminals.get(j).people
                                                .get(l).getJob() + "   gender: " + Country.cities.get(i).terminals.get(j).people
                                                .get(l).getGender() + "   employment salary: " +
                                                Country.cities.get(i).terminals.get(j).people.get(l).getEmploymentSalary()
                                        + "   id: " + Country.cities.get(i).terminals.get(j).people.get(l).getPersonID());
                                    }

                                }
                            }
                        }
                        mayorMenu1(); break;
                    }

                    case 7 : // show hotel information
                    {
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println(" hotels: ");
                        for (int i = 0; i < Country.cities.size(); i++)
                        {
                            if (Country.cities.get(i).getCityName().equals(cityName))
                            {
                                for (int j = 0; j < Country.cities.get(i).hotels.size(); j++)
                                {
                                    System.out.println(" name: " + Country.cities.get(i).hotels.get(j).getName()
                                    + "   address: " + Country.cities.get(i).hotels.get(j).getAddress() +
                                            "   number of stars: " +  Country.cities.get(i).hotels.get(j).getNumStar()
                                    + "   facilities: " + Country.cities.get(i).hotels.get(j).getEnum());

                                    System.out.println(" rooms: ");
                                    for (int k = 0; k < Country.cities.get(i).hotels.get(j).hotelRooms.size(); k++)
                                    {
                                        System.out.println(" room number: " + Country.cities.get(i).hotels.get(j).
                                                hotelRooms.get(k).getRoomNumber() + "   area: " +
                                                Country.cities.get(i).hotels.get(j).hotelRooms.get(k).getArea()
                                        + "   number of bed: " + Country.cities.get(i).hotels.get(j).hotelRooms.get(k)
                                                .getNumBed() + "   price: " + Country.cities.get(i).hotels.get(j)
                                                .hotelRooms.get(k).getRoomPrice());
                                    }
                                }
                            }
                        }
                      mayorMenu1();
                        break;
                    }

                    case 8 : // add trip
                    {
                        try {
                            addTrip();
                        }
                       catch (AbsenceOfDriver | NotEnoughPassenger | TerminalNotFound | TerminalTypeMismatch e)
                       {
                           e.printStackTrace();
                       }
                        mayorMenu1();
                        break;
                    }

                    case 9: // show trips
                    {
                        System.out.println("---------------------------------------------------------------");
                        showTrips(cityName);
                        mayorMenu1();
                        break;
                    }

                    case 10: // back
                    {
                       mayorMenu1();
                       break;
                    }

                }

               mayorMenu1(); break;
            }

            case 3 : // show information of all cities
            {
                System.out.println("--------------------------------------------------------------------");
                System.out.println(Country.name + " :");
                System.out.println(" total population: " + Country.totalCountryPopulation);
                System.out.println(" total budget: " + Country.totalCountryBudget);
                System.out.println(" number of cities: " + Country.cities.size());
                System.out.println("----------------------------------------------------");
                System.out.println(" cities: ");
                for (int i = 0; i < Country.cities.size(); i++)
                {
                    System.out.println(" " + Country.cities.get(i).getCityName() + "   budget: " +
                            Country.cities.get(i).getTotalBudget() + "    population: " +
                            Country.cities.get(i).getPopulation());
                }
                mayorMenu1();
                break;
            }

            case 4 : // show information of a city
            {
                System.out.println("--------------------------------------------------------------------");
                System.out.print(" Enter the name of city: "); String cityName = input.next();
                for (int i = 0; i < Country.cities.size(); i++)
                {
                    if (Country.cities.get(i).getCityName().equals(cityName))
                    {
                        System.out.println(" " + cityName + " : " );
                        System.out.println(" budget: " + Country.cities.get(i).getTotalBudget() +
                                "   population: " + Country.cities.get(i).getPopulation() +
                                "   number of terminals: " + Country.cities.get(i).terminals.size() +
                                "   number of hotels: " + Country.cities.get(i).hotels.size());
                        break;
                    }
                }
                mayorMenu1();
                break;
            }

            case 5 : // log out
            {
                break;
            }

        }
    }

    public void buildTerminal(String cityName, int num1)
    {
        switch (num1)
        {
            case 1 : // build airport
            {
                try
                {
                    System.out.println("\t*****Build Airport*****");
                    System.out.println(" Enter the information : ");
                    System.out.print(" 1) terminal name : "); String terminalName = input.next() ;
                    System.out.print(" 2) address : "); String address = input.next();
                    System.out.print(" 3) area : "); double area = input.nextDouble();
                    System.out.print(" 4) number of vehicles : "); int numVehicles = input.nextInt();
                    System.out.print(" 5) airport type : "); boolean airportType = input.nextBoolean();
                    System.out.print(" 6) number of runway : "); int numRunway = input.nextInt();
                    System.out.println();
                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if(Country.cities.get(i).getCityName().equals(cityName))
                        {
                            if(Country.cities.get(i).spendBudget(400))
                            {
                                Country.cities.get(i).terminals.add(new Airport("airport",400,
                                        cityName, terminalName, address, area, numVehicles, airportType, numRunway));
                                break;
                            }
                        }
                    }
                }
                catch (InputMismatchException | IllegalArgumentException e)
                {
                    e.printStackTrace();
                    mayorMenu1();
                }
                break;
            }

            case 2 : // build bus terminal
            {
                try
                {
                    System.out.println("\t*****Build Bus Terminal*****");
                    System.out.println(" Enter the information : ");
                    System.out.print(" 1) terminal name : "); String terminalName = input.next() ;
                    System.out.print(" 2) address : "); String address = input.next();
                    System.out.print(" 3) area : "); double area = input.nextDouble();
                    System.out.print(" 4) number of vehicles : "); int numVehicles = input.nextInt();
                    System.out.println();

                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if(Country.cities.get(i).getCityName().equals(cityName))
                        {
                            if(Country.cities.get(i).spendBudget(190))
                            {
                                Country.cities.get(i).terminals.add(new BusTerminal("bus terminal",
                                        190, cityName, terminalName, address, area, numVehicles));
                                break;
                            }
                        }
                    }
                }
                catch (InputMismatchException | IllegalArgumentException e)
                {
                    e.printStackTrace();
                    mayorMenu1();
                }
                break;
            }

            case 3: // build shipping port
            {
                try
                {
                    System.out.println("\t*****Build Shipping Port*****");
                    System.out.println(" Enter the information : ");
                    System.out.print(" 1) terminal name : "); String terminalName = input.next() ;
                    System.out.print(" 2) address : "); String address = input.next();
                    System.out.print(" 3) area : "); double area = input.nextDouble();
                    System.out.print(" 4) number of vehicles : "); int numVehicles = input.nextInt();
                    System.out.print(" 5) number of pier : "); int numPier = input.nextInt();
                    System.out.println();

                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if(Country.cities.get(i).getCityName().equals(cityName))
                        {
                            if(Country.cities.get(i).spendBudget(300))
                            {
                                Country.cities.get(i).terminals.add(new ShippingPort("shipping port",
                                        300, cityName, terminalName, address, area, numVehicles, numPier));
                                break;
                            }
                        }
                    }
                }
                catch (InputMismatchException | IllegalArgumentException e)
                {
                    e.printStackTrace();
                    mayorMenu1();
                }
                break;
            }

            case 4 : // build train station
            {
                try
                {

                    System.out.println("\t*****Build Train Station*****");
                    System.out.println(" Enter the information : ");
                    System.out.print(" 1) terminal name : "); String terminalName = input.next() ;
                    System.out.print(" 2) address : "); String address = input.next();
                    System.out.print(" 3) area : "); double area = input.nextDouble();
                    System.out.print(" 4) number of vehicles : "); int numVehicles = input.nextInt();
                    System.out.print(" 5) number of entrance rails :"); int numEntranceRails = input.nextInt();
                    System.out.print(" 6) number of output rails : "); int numOutputRails = input.nextInt();
                    System.out.println();

                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if(Country.cities.get(i).getCityName().equals(cityName))
                        {
                            if(Country.cities.get(i).spendBudget(200))
                            {
                                Country.cities.get(i).terminals.add(new TrainStation("train station",
                                        200, cityName, terminalName, address, area,
                                        numVehicles, numEntranceRails, numOutputRails));
                                break;
                            }
                        }
                    }
                }
                catch (InputMismatchException | IllegalArgumentException e)
                {
                    e.printStackTrace();
                    mayorMenu1();
                }
                break;
            }

            case 5 : // back to menu
            {
               break;
            }
        }

    }

    public void buyVehicle(String cityName, int num1)
    {
        switch (num1)
        {
            case 1 : // buy bus
            {
                try
                {
                    System.out.println("\t*****Buy Bus*****");
                    System.out.println(" Enter the information : ");
                    System.out.print(" 1) capacity : "); int capacity = input.nextInt();
                    System.out.print(" 2) manufacturer name : "); String manufacturerName = input.next();
                    System.out.print(" 3) fuel type : "); String fuelType = input.next();
                    System.out.print(" 4) Maximum speed : "); double maxSpeed = input.nextDouble();
                    System.out.print(" 5) dimensions (large , Medium) : "); String dimensions = input.next();
                    System.out.println();

                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if (Country.cities.get(i).getCityName().equals(cityName))
                        {
                            for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                            {
                                if(Country.cities.get(i).terminals.get(j).getType().equals("bus terminal"))
                                {
                                    System.out.println(" terminal name: " + Country.cities.get(i).terminals
                                            .get(j).getTerminalName());
                                }
                            }

                        }
                    }

                    System.out.print(" Enter terminal name: "); String terminalName = input.next();

                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if (Country.cities.get(i).getCityName().equals(cityName))
                        {
                            if(Country.cities.get(i).spendBudget(150))
                            {
                                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                                {
                                    if(Country.cities.get(i).terminals.get(j).getTerminalName().equals(terminalName))
                                    {
                                        int vehicleID = Vehicle.id ;
                                        Bus bus = new Bus(150, capacity, vehicleID, manufacturerName,fuelType
                                        ,maxSpeed, dimensions);
                                        Country.cities.get(i).terminals.get(j).terminalVehicles.add(bus);
                                        BusTerminal b = (BusTerminal) Country.cities.get(i).terminals.get(j);
                                        b.buses.add(bus);
                                        System.out.println(" the bus id is " + vehicleID);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                catch (InputMismatchException | IllegalArgumentException e)
                {
                    e.printStackTrace();
                    mayorMenu1();
                }
                break;
            }

            case 2 : // buy ship
            {
                try
                {
                    System.out.println("\t*****Buy Ship*****");
                    System.out.println(" Enter the information : ");
                    System.out.print(" 1) capacity : "); int capacity = input.nextInt();
                    System.out.print(" 2) manufacturer name : "); String manufacturerName = input.next();
                    System.out.print(" 3) fuel type : "); String fuelType = input.next();
                    System.out.print(" 4) Minimum depth : "); double minDepth = input.nextDouble();
                    System.out.print(" 5) dimensions (large , Medium) : "); String dimensions = input.next();
                    System.out.println();

                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if (Country.cities.get(i).getCityName().equals(cityName))
                        {
                            for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                            {
                                if(Country.cities.get(i).terminals.get(j).getType().equals("shipping port"))
                                {
                                    System.out.println(" terminal name: " + Country.cities.get(i).terminals
                                            .get(j).getTerminalName());
                                }
                            }

                        }
                    }

                    System.out.print(" Enter terminal name: "); String terminalName = input.next();

                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if (Country.cities.get(i).getCityName().equals(cityName))
                        {
                            if(Country.cities.get(i).spendBudget(170))
                            {
                                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                                {
                                    if(Country.cities.get(i).terminals.get(j).getTerminalName().equals(terminalName))
                                    {
                                        int vehicleID = Vehicle.id ;
                                        Ship ship = new Ship(170, capacity, vehicleID, manufacturerName,
                                                fuelType, minDepth, dimensions);
                                        Country.cities.get(i).terminals.get(j).terminalVehicles.add(ship);
                                        ShippingPort sh = (ShippingPort) Country.cities.get(i).terminals.get(j);
                                        sh.marineVehicles.add(ship);
                                        System.out.println(" the ship id is " + vehicleID);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                catch (InputMismatchException | IllegalArgumentException e)
                {
                    e.printStackTrace();
                    mayorMenu1();
                }
                break;
            }

            case 3 : // buy boat
            {
                try
                {
                    System.out.println("\t*****Buy Boat*****");
                    System.out.println(" Enter the information : ");
                    System.out.print(" 1) capacity : "); int capacity = input.nextInt();
                    System.out.print(" 2) manufacturer name : "); String manufacturerName = input.next();
                    System.out.print(" 3) fuel type : "); String fuelType = input.next();
                    System.out.print(" 4) Minimum depth : "); double minDepth = input.nextDouble();
                    System.out.print(" 5) boat type (launch , lifeboat) : ");String boatType = input.next();

                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if (Country.cities.get(i).getCityName().equals(cityName))
                        {
                            for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                            {
                                if(Country.cities.get(i).terminals.get(j).getType().equals("shipping port"))
                                {
                                    System.out.println(" terminal name: " + Country.cities.get(i).terminals
                                            .get(j).getTerminalName());
                                }
                            }

                        }
                    }

                    System.out.print(" Enter terminal name: "); String terminalName = input.next();
                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if (Country.cities.get(i).getCityName().equals(cityName))
                        {
                            if(Country.cities.get(i).spendBudget(120))
                            {
                                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                                {
                                    if(Country.cities.get(i).terminals.get(j).getTerminalName().equals(terminalName))
                                    {
                                        int vehicleID = Vehicle.id ;
                                        Boat boat = new Boat(120, capacity, vehicleID, manufacturerName,
                                                fuelType, minDepth, boatType);
                                        Country.cities.get(i).terminals.get(j).terminalVehicles.add(boat);
                                        ShippingPort sh = (ShippingPort) Country.cities.get(i).terminals.get(j);
                                        sh.marineVehicles.add(boat);
                                        System.out.println(" the boat id is " + vehicleID);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                catch (InputMismatchException | IllegalArgumentException e)
                {
                    e.printStackTrace();
                    mayorMenu1();
                }
                break;
            }

            case 4 : // buy airliner
            {
                try
                {
                    System.out.println("\t*****Buy Airliner*****");
                    System.out.println(" Enter the information : ");
                    System.out.print(" 1) capacity : "); int capacity = input.nextInt();
                    System.out.print(" 2) manufacturer name : "); String manufacturerName = input.next();
                    System.out.print(" 3) Maximum height : "); double maxHeight = input.nextDouble();
                    System.out.print(" 4) airstrip length : "); double airstripLength = input.nextDouble();
                    System.out.print(" 5) number of cabin crew : "); int numberCabinCrew = input.nextInt();
                    System.out.print(" 6) Classification of aircraft seats : ");
                    String classificationAircraftSeats = input.next();
                    System.out.println();

                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if (Country.cities.get(i).getCityName().equals(cityName))
                        {
                            for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                            {
                                if(Country.cities.get(i).terminals.get(j).getType().equals("airport"))
                                {
                                    System.out.println(" terminal name: " + Country.cities.get(i).terminals
                                            .get(j).getTerminalName());
                                }
                            }

                        }
                    }
                    System.out.print(" Enter terminal name: "); String terminalName = input.next();

                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if (Country.cities.get(i).getCityName().equals(cityName))
                        {
                            if(Country.cities.get(i).spendBudget(180))
                            {
                                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                                {
                                    if(Country.cities.get(i).terminals.get(j).getTerminalName().equals(terminalName))
                                    {
                                        int vehicleID = Vehicle.id ;
                                        Airliner airliner = new Airliner(180, capacity, vehicleID,
                                                manufacturerName, maxHeight, airstripLength, numberCabinCrew,
                                                classificationAircraftSeats);
                                        Country.cities.get(i).terminals.get(j).terminalVehicles.add(airliner);
                                        Airport a = (Airport) Country.cities.get(i).terminals.get(j);
                                        a.airVehicles.add(airliner);
                                        System.out.println(" the airliner id is " + vehicleID);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                catch (InputMismatchException | IllegalArgumentException e)
                {
                    e.printStackTrace();
                    mayorMenu1();
                }
                break;
            }

            case 5 : // buy cargo plane
            {
                try
                {
                    System.out.println("\t*****Buy cargo plane*****");
                    System.out.println(" Enter the information : ");
                    System.out.print(" 1) capacity : "); int capacity = input.nextInt();
                    System.out.print(" 2) manufacturer name : "); String manufacturerName = input.next();
                    System.out.print(" 3) Maximum height : "); double maxHeight = input.nextDouble();
                    System.out.print(" 4) airstrip length : "); double airstripLength = input.nextDouble();
                    System.out.print(" 5) Maximum weight : "); double maxWeight = input.nextDouble();
                    System.out.println();

                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if (Country.cities.get(i).getCityName().equals(cityName))
                        {
                            for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                            {
                                if(Country.cities.get(i).terminals.get(j).getType().equals("airport"))
                                {
                                    System.out.println(" terminal name: " + Country.cities.get(i).terminals
                                            .get(j).getTerminalName());
                                }
                            }

                        }
                    }
                    System.out.print(" Enter terminal name: "); String terminalName = input.next();

                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if (Country.cities.get(i).getCityName().equals(cityName))
                        {
                            if(Country.cities.get(i).spendBudget(170))
                            {
                                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                                {
                                    if(Country.cities.get(i).terminals.get(j).getTerminalName().equals(terminalName))
                                    {
                                        int vehicleID = Vehicle.id ;
                                        CargoPlane cargoPlane = new CargoPlane(170, capacity, vehicleID,
                                                manufacturerName, maxHeight, airstripLength, maxWeight);

                                        Country.cities.get(i).terminals.get(j).terminalVehicles.add(cargoPlane);
                                        Airport a = (Airport) Country.cities.get(i).terminals.get(j);
                                        a.airVehicles.add(cargoPlane);
                                        System.out.println(" the cargo plane id is " + vehicleID);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                catch (InputMismatchException | IllegalArgumentException e)
                {
                    e.printStackTrace();
                    mayorMenu1();
                }
               break;
            }

            case 6 : // buy train
            {
                try
                {
                    System.out.println("\t*****Buy Train*****");
                    System.out.println(" Enter the information : ");
                    System.out.print(" 1) capacity : "); int capacity = input.nextInt();
                    System.out.print(" 2) manufacturer name : "); String manufacturerName = input.next();
                    System.out.print(" 3) fuel type : "); String fuelType = input.next();
                    System.out.print(" 4) Maximum speed : "); double maxSpeed = input.nextDouble();
                    System.out.print(" 5) number of wagon : "); int numWagon = input.nextInt();
                    System.out.print(" 6) number of star : "); int numStar = input.nextInt();
                    System.out.println();

                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if (Country.cities.get(i).getCityName().equals(cityName))
                        {
                            for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                            {
                                if(Country.cities.get(i).terminals.get(j).getType().equals("train station"))
                                {
                                    System.out.println(" terminal name: " + Country.cities.get(i).terminals
                                            .get(j).getTerminalName());
                                }
                            }

                        }
                    }
                    System.out.print(" Enter terminal name: "); String terminalName = input.next();

                    for (int i = 0; i < Country.cities.size(); i++)
                    {
                        if (Country.cities.get(i).getCityName().equals(cityName))
                        {
                            if(Country.cities.get(i).spendBudget(140))
                            {
                                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                                {
                                    if(Country.cities.get(i).terminals.get(j).getTerminalName().equals(terminalName))
                                    {
                                        int vehicleID = Vehicle.id ;
                                        Train train = new Train(140, capacity, vehicleID, manufacturerName,
                                                fuelType, maxSpeed, numWagon, numStar);

                                        Country.cities.get(i).terminals.get(j).terminalVehicles.add(train);
                                        TrainStation t = (TrainStation) Country.cities.get(i).terminals.get(j);
                                        t.trains.add(train);
                                        System.out.println(" the train id is " + vehicleID);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                catch (InputMismatchException | IllegalArgumentException e)
                {
                    e.printStackTrace();
                    mayorMenu1();
                }
                break;
            }

            case 7 : // back to main menu
            {
                break;
            }

        }
    }


    public void hireDriver(String cityName, int num1)
    {
        System.out.print(" Enter job : ");
        String job = input.nextLine();
        String terminalType = "" ;

        switch (job) {
            case "sailor" -> terminalType = "shipping port";
            case "pilot", "crewman" -> terminalType = "airport";
            case "bus driver" -> terminalType = "bus terminal";
            case "engine driver" -> terminalType = "train station";
        }


        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals(cityName))
            {
                for (int j = 0; j < Country.cities.get(i).people.size(); j++)
                {
                    if(Country.cities.get(i).people.get(j).getJob().equals(job))
                    {
                        System.out.print(" name: " + Country.cities.get(i).people.get(j).getName());
                        System.out.print("   last name: " + Country.cities.get(i).people.get(j).getLastName());
                        System.out.print("   year of birth: " + Country.cities.get(i).people.get(j).getYearBirth());
                        System.out.print("   place of birth: " + Country.cities.get(i).people.get(j).getBirthplace());
                        System.out.print("   job: " + Country.cities.get(i).people.get(j).getJob());
                        System.out.print("   gender: " + Country.cities.get(i).people.get(j).getGender());
                        System.out.print("   employment salary: " + Country.cities.get(i).people.get(j).getEmploymentSalary());
                        System.out.println("   id: " + Country.cities.get(i).people.get(j).getPersonID());
                        System.out.println("------------------------------------------------------------------------");
                    }
                }

            }
        }

        System.out.print(" Enter the person's ID : ");
        int id = input.nextInt();
        input.nextLine();

        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals(cityName))
            {
                for (int j = 0; j < Country.cities.get(i).people.size(); j++)
                {
                    if (Country.cities.get(i).people.get(j).getPersonID() == id)
                    {
                        if (Country.cities.get(i).people.get(j).getJob().equals(job))
                        {
                            for (int k = 0; k < Country.cities.get(i).terminals.size(); k++)
                            {
                                if(Country.cities.get(i).terminals.get(k).getType().equals(terminalType))
                                {
                                    System.out.println(" terminal name: " + Country.cities.get(i).terminals.get(k)
                                            .getTerminalName());
                                }
                            }
                            System.out.print(" choose one terminal: "); String terminalName = input.next();
                            for (int l = 0; l < Country.cities.get(i).terminals.size(); l++)
                            {
                                if(Country.cities.get(i).terminals.get(l).getTerminalName().equals(terminalName))
                                {
                                    Country.cities.get(i).terminals.get(l).people.add(Country.cities.get(i).people
                                            .get(j));
                                    System.out.println();
                                    System.out.println(" Successful hiring");
                                    break;
                                }
                            }
                        }
                        else
                        {
                            System.out.println(" The entered ID is not correct !");
                            mayorMenu1();
                        }

                    }

                }
            }
        }

    }


    public void addTrip () throws AbsenceOfDriver, NotEnoughPassenger, TerminalNotFound, TerminalTypeMismatch
    {
        boolean found = true;
        ArrayList<Person> travelers = new ArrayList<>();
        Terminal originTerminal1 = null;
        Terminal destinationTerminal1 = null ;
        Person driver = null ;
        double travelCost = 0;
        Vehicle vehicle = null;

        // چاپ شهروندانی که مجاز به سفر اند
        for (int i = 0; i < Country.cities.size(); i++)
        {
            if(Country.cities.get(i).getCityName().equals("tehran"))
            {
                for (int j = 0; j < Country.cities.get(i).people.size(); j++)
                {
                    for (int k = 0; k < Country.cities.get(i).terminals.size(); k++)
                    {
                        for (int l = 0; l < Country.cities.get(i).terminals.get(k).people.size(); l++)
                        {
                            if(Country.cities.get(i).people.get(j).getPersonID() != Country.cities.get(i).terminals
                                    .get(k).people.get(l).getPersonID())
                            {
                                found = false;
                            }
                            else
                            {
                                found = true;
                                break;
                            }
                        }
                        if(found)
                        {
                            break;
                        }
                    }
                    if (!found)
                    {
                        System.out.println(" name: " + Country.cities.get(i).people.get(j).getName() + "  " +
                                Country.cities.get(i).people.get(j).getLastName() + "   gender: "
                                + Country.cities.get(i).people.get(j).getGender() + "   job: "
                                + Country.cities.get(i).people.get(j).getJob() + "    " +
                                "   id: " + Country.cities.get(i).people.get(j).getPersonID());
                    }
                }
            }
        }
        System.out.println("---------------------------------------------------------------");


        // اد کردن مسافران انتخابی به ارایه
        int choice;
        do
        {
            System.out.print(" * Enter the ID of the desired passenger  or Enter 0 for end");
            System.out.print(" enter your choice: "); choice = input.nextInt();
            if(choice != 0)
            {
                for (int i = 0; i < Country.cities.size(); i++)
                {
                    if (Country.cities.get(i).getCityName().equals("tehran"))
                    {
                        for (int j = 0; j < Country.cities.get(i).people.size(); j++)
                        {
                            if(Country.cities.get(i).people.get(j).getPersonID() == choice)
                            {
                                travelers.add(Country.cities.get(i).people.get(j));
                                break;
                            }

                        }
                    }
                }
            }

        }while (choice != 0);

        System.out.println("---------------------------------------------------------------");


        // چاپ ترمینال های مبدا برای سفر کردن
        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals("tehran"))
            {
                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                {
                    if(Country.cities.get(i).terminals.get(j).getType().equals("bus terminal") ||
                    Country.cities.get(i).terminals.get(j).getType().equals("airport"))
                    {
                        System.out.println(" terminal name: " + Country.cities.get(i).terminals.get(j).getTerminalName());
                    }
                }
            }
        }

        System.out.print(" Enter the name of origin terminal: "); String originTerminalName = input.next();
        System.out.println("---------------------------------------------------------------");

        // چاپ وسایل نقلیه ی ترمینال مورد نظر در شهر مبدا
        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals("tehran"))
            {
                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                {
                    if(Country.cities.get(i).terminals.get(j).getTerminalName().equals(originTerminalName))
                    {
                        if (Country.cities.get(i).terminals.get(j).getType().equals("airport"))
                        {
                            Airport a = (Airport) Country.cities.get(i).terminals.get(j);
                            for (int k = 0; k < a.airVehicles.size(); k++)
                            {
                                System.out.println(" airport--->    capacity: " + a.airVehicles.get(k).getCapacity() +
                                        "     id: " + a.airVehicles.get(k).getVehicleID());
                            }
                        }

                        else if(Country.cities.get(i).terminals.get(j).getType().equals("bus terminal"))
                        {
                            BusTerminal b = (BusTerminal) Country.cities.get(i).terminals.get(j);
                            for (int k = 0; k < b.buses.size(); k++)
                            {
                                System.out.println(" bus--->    capacity: " + b.buses.get(k).getCapacity() +
                                        "     id: " + b.buses.get(k).getVehicleID());
                            }

                        }
                    }

                }
            }
        }

        System.out.print(" Enter vehicle id: "); int vehicleId = input.nextInt();
        System.out.println("---------------------------------------------------------------");

        // چاپ راننده های ترمینال مبدا
        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals("tehran"))
            {
                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                {
                    if (Country.cities.get(i).terminals.get(j).getTerminalName().equals(originTerminalName))
                    {
                        for (int k = 0; k < Country.cities.get(i).terminals.get(j).people.size(); k++)
                        {
                            System.out.println(" driver--->  " + "  name: " + Country.cities.get(i).terminals.get(j)
                                    .people.get(k).getName() + "   " + Country.cities.get(i).terminals.get(j)
                                    .people.get(k).getLastName() + "   job: " + Country.cities.get(i).terminals.get(j)
                                    .people.get(k).getJob() + "    id: " + Country.cities.get(i).terminals.get(j)
                                    .people.get(k).getPersonID());
                        }
                    }
                }
            }
        }

        System.out.println();
        System.out.print(" Enter driver id : "); int driverId = input.nextInt();
        System.out.println("---------------------------------------------------------------");

        System.out.print("  Enter the name of destination city: "); String destinationCity = input.next();
        System.out.println();

        // چاپ ترمینال های مقصد
        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals(destinationCity))
            {
                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                {
                    if(Country.cities.get(i).terminals.get(j).getType().equals("bus terminal") ||
                            Country.cities.get(i).terminals.get(j).getType().equals("airport"))
                    {
                        System.out.println(" terminal name: " + Country.cities.get(i).terminals.get(j).getTerminalName());
                    }
                }
            }
        }

        System.out.print(" Enter the name of destination terminal: "); String destinationTerminalName = input.next();
        System.out.println("---------------------------------------------------------------");
        System.out.print(" Enter date: "); int date = input.nextInt();

        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++چک کردن درستی اطلاعات سفر

        // دریافت نوع ترمینال مقصد
        String destinationTerminalType = "" ;
        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals(destinationCity))
            {
                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                {
                    if(Country.cities.get(i).terminals.get(j).getTerminalName().equals(destinationTerminalName))
                    {
                        destinationTerminalType = Country.cities.get(i).terminals.get(j).getType();
                        destinationTerminal1 = Country.cities.get(i).terminals.get(j); // دریافت شی ترمینال مقصد
                    }

                }
            }
        }

        // دریافت نوع ترمینال مبدا
        String originTerminalType = "" ;
        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals("tehran"))
            {
                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                {
                    if(Country.cities.get(i).terminals.get(j).getTerminalName().equals(originTerminalName))
                    {
                        originTerminalType = Country.cities.get(i).terminals.get(j).getType();
                        originTerminal1 = Country.cities.get(i).terminals.get(j);
                    }

                }
            }
        }

        if(!(originTerminalType.equals(destinationTerminalType)))
        {
            throw new TerminalTypeMismatch();
        }

        //  بررسی وجود داشتن ترمینال مبدا
        boolean found1 = false;
        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals("tehran"))
            {
                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                {
                    if(Country.cities.get(i).terminals.get(j).getTerminalName().equals(originTerminalName))
                    {
                        found1 = true;
                    }

                }
            }
        }
        if (!found1) {throw new TerminalNotFound();}
        //**************************************************

        //  بررسی وجود داشتن ترمینال مقصد
        boolean found2 = false;
        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals(destinationCity))
            {
                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                {
                    if(Country.cities.get(i).terminals.get(j).getTerminalName().equals(destinationTerminalName))
                    {
                        found2 = true;
                    }

                }
            }
        }
        if (!found2) {throw new TerminalNotFound();}
        //*********************************************************************

        //بررسی وجود داشتن راننده در ترمینال مبدا
        boolean found3 = false;
        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals("tehran"))
            {
                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                {
                    if(Country.cities.get(i).terminals.get(j).getTerminalName().equals(originTerminalName))
                    {
                       for (int k = 0; k < Country.cities.get(i).terminals.get(j).people.size(); k++)
                       {
                           if (Country.cities.get(i).terminals.get(j).people.get(k).getPersonID() == driverId)
                           {
                               found3 = true;
                               driver = Country.cities.get(i).terminals.get(j).people.get(k);
                           }
                       }
                    }

                }
            }
        }

        if (!found3) {throw new AbsenceOfDriver();}

        //****************************************
        // بررسی تعداد مسافران
        int num = travelers.size();
        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals("tehran"))
            {
                for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
                {
                    if (Country.cities.get(i).terminals.get(j).getTerminalName().equals(originTerminalName))
                    {
                        for (int k = 0; k < Country.cities.get(i).terminals.get(j).terminalVehicles.size(); k++)
                        {
                            if(Country.cities.get(i).terminals.get(j).terminalVehicles.get(k).getVehicleID() == vehicleId)
                            {
                                vehicle = Country.cities.get(i).terminals.get(j).terminalVehicles.get(k);
                                if(num < (Country.cities.get(i).terminals.get(j).terminalVehicles.get(k)
                                        .getCapacity() / 2))
                                {
                                    throw new NotEnoughPassenger();
                                }
                            }
                        }
                    }
                }
            }
        }

        // محاسبه هزینه سفر
        travelCost = originTerminal1.calculateTravelCost(travelers, vehicle);
        // اضافه شدن هزینه سفر به موجودی شهر مبدا
        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals("tehran"))
            {
                Country.cities.get(i).setTotalBudget(Country.cities.get(i).getTotalBudget() + travelCost);
                break;
            }
        }

        // ایجاد سفر
        originTerminal1.newTravel(originTerminal1, destinationTerminal1, driver, travelCost, date,
                vehicle, travelers);
        System.out.println(" The trip was successful.");

        // افزودن مسافران به جمعیت شهر مقصد
        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals(destinationCity))
            {
               Country.cities.get(i).addPopulation(travelers.size());
               break;
            }
        }

        found = true; found1 = false; found2 = false; found3 = false ;

    }


    public void buildHotel(String cityName)
    {
        System.out.println("\t*****Build Hotel*****");
        System.out.println(" Enter the information : ");
        System.out.print(" 1) hotel name : "); String name = input.next();
        System.out.print(" 2) hotel address : "); String address = input.next();
        System.out.print(" 3) number of star : "); int numStar = input.nextInt();
        System.out.print(" 4) number of room : "); int numRoom = input.nextInt();

        for (int i = 0; i < Country.cities.size(); i++)
        {
            if(Country.cities.get(i).getCityName().equals(cityName))
            {
                if(Country.cities.get(i).spendBudget(250))
                {
                    Country.cities.get(i).hotels.add(new Hotel(name, 250, address, numStar, numRoom));
                    break;
                }
            }
        }
    }

    public void buildRoom(String cityName)
    {
        System.out.println("\t*****Build Hotel Room*****");
        System.out.println(" Enter the information : ");
        System.out.print(" 1) room number : "); int roomNumber = input.nextInt();
        System.out.print(" 2) number of bed : "); int numBed = input.nextInt();
        System.out.print(" 3) room area : "); double area = input.nextDouble();
        System.out.print(" 4) Accommodation fees : "); double price = input.nextDouble();
        System.out.println("-----------------------------------------------------------------");

        System.out.println(" Hotels: ");
        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals(cityName))
            {
                for (int j = 0; j < Country.cities.get(i).hotels.size(); j++)
                {
                    System.out.println("  " + Country.cities.get(i).hotels.get(j));
                }
            }
        }

        System.out.print(" Enter the name of hotel: "); String hotelName = input.next();

        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals(cityName))
            {
                for (int j = 0; j < Country.cities.get(i).hotels.size(); j++)
                {
                    if (Country.cities.get(i).hotels.get(j).getName().equals(hotelName))
                    {
                         Country.cities.get(i).hotels.get(j).hotelRooms.add(new HotelRoom(roomNumber, numBed,
                                 area, price));
                         break;
                    }
                }
            }
        }
    }

    public void showTrips(String cityName)
    {
        System.out.print(" Enter the name of terminal: "); String terminalName = input.next();
        System.out.print(" do you want to see incoming trips?    *true  or  *false  : ");
        boolean incoming = input.nextBoolean();
        System.out.print(" do you want to see output trips?    *true  or  *false  : ");
        boolean output = input.nextBoolean();

        for (int i = 0; i < Country.cities.size(); i++)
        {
            if (Country.cities.get(i).getCityName().equals(cityName))
            {
               for (int j = 0; j < Country.cities.get(i).terminals.size(); j++)
               {
                   if(Country.cities.get(i).terminals.get(j).getTerminalName().equals(terminalName))
                   {
                       Country.cities.get(i).terminals.get(j).travelSorting();

                       Country.cities.get(i).terminals.get(j).travelHistory(Country.cities.get(i).terminals
                               .get(j), incoming, output);
                       break;
                   }
               }
            }
        }
    }



}
