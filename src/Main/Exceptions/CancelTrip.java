package Main.Exceptions;

public class CancelTrip extends Exception // لغو سفر
{
    public CancelTrip(String massage)
    {
        super(massage);
    }
}
