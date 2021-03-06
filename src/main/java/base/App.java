package base;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Glenroy Little
 */
import java.util.Scanner;
/**
 Exercise 20 - Multistate Sales Tax Calculator
 More complex programs may have decisions nested in other decisions, so that when one decision is made, additional decisions must be made.

 Create a tax calculator that handles multiple states and multiple counties within each state.
 The program prompts the user for the order amount and the state where the order will be shipped.

 Wisconsin residents must be changed 5% sales tax with an additional county-level charge. For Wisconsin residents, prompt for the county of residence.
 For Eau Claire county residents, add an additional 0.005 tax.
 For Dunn county residents, add an additional 0.004 tax.
 Illinois residents must be charged 8% sales tax with no additional county-level charge.
 All other states are not charged tax.
 The program then displays the tax and the total for Wisconsin and Illinois residents but just the total for everyone else.

 Example Output
 What is the order amount? 10
 What state do you live in? Wisconsin
 What county do you live in? Dane
 The tax is $0.50.
 The total is $10.50.

 Constraints
 Ensure that all money is rounded up to the nearest cent.
 Use a single output statement at the end of the program to display the program results.

 Challenges
 Add support for your state and county.
 Allow the user to enter a state abbreviation and county name in upper, lower, or mixed case.
 Allow the user to also enter the state’s full name in upper, lower, or mixed case.
 Implement the program using data structures to avoid nested if statements.
 */
public class App 
{
    static Scanner in = new Scanner(System.in);

    public static void main( String[] args )
    {
        App myApp = new App();
        double tax;

        Integer amount = myApp.getorderamount();
        String state = myApp.getstate();

        if(state.equals("Wisconsin"))
        {
            String county = myApp.getcounty();
            if(county.equals("Eau Claire"))
            {
                tax = .055;
            }
            else if(county.equals("Dunn"))
            {
                tax = .054;
            }
            else
            {
                tax = .05;
            }
        }
        else if(state.equals("Illinois"))
        {
            tax = .08;
        }
        else
        {
            tax = 0;
        }

        double totaltax = myApp.calctax(amount, tax);
        double total = myApp.calctotal(amount, totaltax);

        myApp.output(totaltax, total);
    }

    public void output(double totaltax, double total)
    {
        System.out.printf("The tax is $%.2f.%nThe total is $%.2f.", totaltax, total);
    }

    public double calctotal(Integer amount, double totaltax)
    {
        double calctotal = amount + totaltax;
        return calctotal;
    }

    public double calctax(Integer amount, double tax)
    {
        double totaltax = amount * tax;
        return totaltax;
    }

    public String getcounty()
    {
        System.out.print("What county do you live in? ");
        String county = in.nextLine();
        return county;
    }

    public String getstate()
    {
        System.out.print("What state do you live in? ");
        String state = in.nextLine();
        return state;
    }

    public Integer getorderamount()
    {
        System.out.print("What is the order amount? ");
        Integer amount = in.nextInt();

        //eating the extra line for the next scanner
        in.nextLine();

        return amount;
    }
}
