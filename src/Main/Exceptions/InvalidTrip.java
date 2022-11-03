package Main.Exceptions;

public class InvalidTrip extends Exception // سفر نامعتبر
{
    public InvalidTrip(String massage)
    {
        super(massage);
    }
}
