/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: ( random number generator and user must guess the number in 7 or less tries) 
 * Due: 2/24/23
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Eduardo Camacho 
*/


import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		
		int guess=0,highGuess=0,lowGuess=0;
		boolean bool=false;
		String choice;
		final int MAX_TRIES= 7;

		Scanner keyboard = new Scanner(System.in);
		
		while(true)
		{
			lowGuess=1;
			highGuess=100;
			int randomNumber = RNG.rand();
			
			System.out.println("This application generates a random integer between 0 and 100");
			System.out.println("and asks the user to guess repeatedly  until they guess it correctly.");
			System.out.println("\nEnter the first guess:");
			
			guess=keyboard.nextInt();
			
				if(guess==randomNumber)
				{
					System.out.println("Congratulations, you guessed correctly");
				}
				else
				{
					
						while(true)
						{
							do
							{
								bool=RNG.inputValidation(guess,lowGuess,highGuess);
								if(bool)
								{
									break;
								}
								guess=keyboard.nextInt();
							}while(!bool);
							
							if(guess<randomNumber)
							{
								lowGuess=guess;
								System.out.println("Your guess is too low");
							}
							else if(guess>randomNumber)
							{
								highGuess=guess;
								System.out.println("Your guess is too high");
							}
							else
							{
								System.out.println("Congratulations, you guessed correctly");
								break;
							}
							if(RNG.getCount()==MAX_TRIES)
							{
								System.out.println("You have exceeded the maximum number of guesses, 7 Try again");
								System.exit(0);
							}
							System.out.println("Number of guesses is: "+RNG.getCount());
							System.out.println("Enter your next guess between "+lowGuess+" and "+highGuess);
							guess=keyboard.nextInt();
						}
				
				
				}
			System.out.println("Try again? (yes or no)");
			
			keyboard.nextLine();
			choice=keyboard.nextLine();
			
			if(choice.equalsIgnoreCase("No")|| choice.equalsIgnoreCase("no"))
			{
				System.out.println("Thanks for playing");
				System.out.println("Programmer name: Eduardo Camacho");
				break;
			}
			else
			{
				RNG.resetCount();
			}    
		}
	}
}