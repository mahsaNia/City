package Main;

import java.util.Scanner;

public class MainClass
{
    public static void main(String[] args)
    {
        MayorManager mayorManager = new MayorManager();
        int user_choice ;
        Scanner input = new Scanner(System.in) ;

        do
        {
            System.out.println("-------------------------------------------------------------");
            System.out.println("^^^^^^^^^^ Welcome ^^^^^^^^^^");
            System.out.println("-------------------------------------------------------------");
            System.out.println("\tMenu");
            System.out.println(" 1) Mayor login\n 2) Exit");
            System.out.print("\tEnter your choice ----> ");
            user_choice = input.nextInt() ;

            switch (user_choice)
            {
                case 1 :
                {
                    mayorManager.buildCapital();
                    mayorManager.mayorMenu1();
                    break;
                }
            }

        }while (user_choice != 2) ; // Exit
    }
}
