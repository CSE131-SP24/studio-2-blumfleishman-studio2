package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		
		System.out.println("Enter Start Amount: ");
		int startAmount = scan.nextInt();
		
		System.out.println("Enter Your Chance of Winning: ");
		double winChance = scan.nextDouble();
		
		System.out.println("Enter Your Win Limit: ");
		int winLimit = scan.nextInt();
		
		System.out.println("Enter Total Simulations: ");
		int totalSimulations = scan.nextInt();
		int currentSimulation = 0;
		int numberLosses = 0 ;
		
		while (startAmount > 0 && currentSimulation < totalSimulations )
		{
			double winorlose = Math.random(); 
			if (winorlose < winChance)
			{
	
				startAmount++;
				currentSimulation++;
				System.out.println("You Win Simulation " + currentSimulation + ": " + startAmount);
			}
			else 
			{
				startAmount--;
				currentSimulation++;
				numberLosses++;
				System.out.println("You Lose Simulation " + currentSimulation + ": " + startAmount);
			}
		}  
		System.out.println("Losses: " + numberLosses + " Simulations: " + currentSimulation);
		double expectedRuinRate;
		if (winChance == .5)
		{
			double rate = startAmount / winLimit ;
			expectedRuinRate = 1- rate;
		}
		else
		{
			double a1 = (1-winChance);
			double a = a1/winChance ;
			expectedRuinRate = (Math.pow(a, startAmount) - Math.pow(a,winLimit)) / ( 1 - (Math.pow(a, winLimit)));
		}
		
		double ruinRate = numberLosses/currentSimulation;
		System.out.println("Expected ruin rate: " + expectedRuinRate + " Actual Ruin Rate: " + ruinRate);
	}

}
