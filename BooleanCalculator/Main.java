import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        System.out.println("Welcome to the Laws of Boolean Algebra!");

        int choice;
        choice = printMenu();

        while (choice!=4){
            if(choice == 1)
                commutativeLaw();

            else if(choice == 2)
                distributiveLaw();

            else if(choice == 3)
                absorptionLaw();
        }

    }


    public static int printMenu()
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println( "Please select a number from the menu." );
        System.out.println( "1 - Commutative Law" );
        System.out.println( "2 - Distributive Law" );
        System.out.println( "3 - Absorption Law" );
        System.out.println( "4 - Quit" );
        System.out.println("--------------------------------------------------------------");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try{

            int choice = Integer.parseInt(in.readLine());
            return choice;
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new Error("IOException");
        }
    }

    public static void commutativeLaw()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("You have entered for Commutative Law\n");
        System.out.println("Enter a value of x [true or false is only accepted]");
        boolean xBool = input.nextBoolean();  // Read user input

        System.out.println("Enter a value of y [true or false is only accepted]");
        boolean yBool = input.nextBoolean();  // Read user input

         String xString = Boolean.toString(xBool);
         if(xBool == true) {
             xString = "t";
         }
         else xString = "f";

        String yString = Boolean.toString(yBool);
        if(yBool == true) {
            yString = "t";
        }
        else yString = "f";
        System.out.println("--------------------------------------------------------------");

        boolean answer;
        boolean secondAnswer;
        String result;
        String result2;

        answer = (xBool&&yBool) == (yBool&&xBool);

        if(answer == true)
            result = "yes";
        else
            result = "no";


        secondAnswer = (xBool||yBool) == (yBool||xBool);

        if(secondAnswer == true)
            result2 = "yes";
        else
            result2 = "no";

        System.out.println("Does " + xString + " + " + yString + " = " + yString + " + " + xString + "?");
        System.out.println(result);
        System.out.println("Does " + xString + yString + " = " + yString + xString + "?");
        System.out.println(result2);
        System.out.println("They are both correct " + xString + " + " + yString + "=" + yString + " + " + xString + " and " + xString + yString + " = " + yString + xString );
        System.out.println("--------------------------------------------------------------");

        System.exit(0);
    }

    public static void distributiveLaw()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("You have entered for Distributive Law\n");
        System.out.println("Enter a value of x [true or false is only accepted]");
        boolean xBool = input.nextBoolean();  // Read user input

        System.out.println("Enter a value of y [true or false is only accepted]");
        boolean yBool = input.nextBoolean();  // Read user input    boolean x = input.nextBoolean();  // Read user input


        System.out.println("Enter a value of z [true or false is only accepted]");
        boolean zBool = input.nextBoolean();  // Read user input
        System.out.println("--------------------------------------------------------------");

        //convert boolean to string
        String xString = Boolean.toString(xBool);
        String yString = Boolean.toString(yBool);
        String zString = Boolean.toString(zBool);

        if(xBool == true)
            xString = "t";
        else
            xString = "f";

        if(yBool == true)
            yString = "t";

        else
            yString = "f";


        if(zBool == true)
            zString = "t";
        else
            zString = "f";



        String result;
        String result2;
        boolean answer;
        boolean secondAnswer;

        answer = (xBool&&(yBool||zBool)==(xBool&&yBool)||(xBool&&zBool));
        if(answer=true)
            result = "yes";
        else
            result = "no";

        secondAnswer =((xBool||(yBool&&zBool))==((xBool||yBool)&&(xBool||zBool)));

        if(secondAnswer=true)
            result2 = "yes";
        else
            result2 = "no";


        System.out.println("Does " + xString + "+" + yString + zString + " = ("  + xString + yString + ")(" + xString + zString + ")?");
        System.out.println(result);

        System.out.println("Does " + xString + "(" + yString + "+" + zString + ") = "  + xString + yString + "+" + xString + zString + "?");
        System.out.println(result2);

        System.out.println("They are both correct "+ xString + "+" + yString + zString + "=("  + xString + yString + ")(" + xString + zString + ") and " +
                        xString + "(" + yString + "+" + zString + ")="  + xString + yString + "+" + xString + zString
                );
        System.out.println("--------------------------------------------------------------");

        System.exit(0);

    }

    public static void absorptionLaw(){
        Scanner input = new Scanner(System.in);
        System.out.println("You have entered for absorption Law\n");
        System.out.println("Enter a value of x [true or false is only accepted]");
        boolean xBool = input.nextBoolean();  // Read user input

        System.out.println("Enter a value of y [true or false is only accepted]");
        boolean yBool = input.nextBoolean();  // Read user input

        String xString = Boolean.toString(xBool);
        if(xBool == true) {
            xString = "t";
        }
        else xString = "f";

        String yString = Boolean.toString(yBool);
        if(yBool == true) {
            yString = "t";
        }
        else yString = "f";
        System.out.println("--------------------------------------------------------------");

        boolean answer;
        boolean secondAnswer;
        String result;
        String result2;

        answer = xBool&&(xBool||yBool) == (xBool);

        if(answer == true)
            result = "yes";
        else
            result = "no";


        secondAnswer = xBool||(xBool||yBool) == (xBool);

        if(secondAnswer == true)
            result2 = "yes";
        else
            result2 = "no";
        System.out.println("Does " + xString + " + (" + xString + yString + ") = " + xString + "?");
        System.out.println(result);
        System.out.println("Does " + xString + "(" + xString + " + " + yString + ")" + "=" + xString + "?");
        System.out.println(result2);
        System.out.println("They are both correct " + xString + " + (" + xString + yString + ")=" + xString + " and " + xString + "(" + xString + " + " + yString + ")" + "=" + xString);
        System.out.println("--------------------------------------------------------------");

        System.exit(0);
    }
}
