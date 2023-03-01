import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Date March 1-2023
 * This class is the Birthday program where it will calculate the probability of 
 * any two people who share the same birthday in the (n) number of students.
 * @author Brandon_Pacheco
 * @version 1.0
 *
 */
public class Birthday {
	/**
	 * A global Random object.
	 */
	private Random rand = new Random();
	/**
	 * A global Scanner object
	 */
	private Scanner in = new Scanner(System.in);
	/**
	 * A global ArrayList
	 */
	private ArrayList<BirthdayPerson> list = new ArrayList<>();
	
	/**
	 * This method is responsible for creating a BirthdayPerson object and storing an int value birthday
	 * @param count An int value that represents the number of people to make.
	 */
	private void makePerson(int count) {
		
		if(!list.isEmpty()) {
			list.clear();
		}
		for(int i = 0; i < count; i++) 
		{
			int birthday = rand.nextInt(365)+ 1;
			list.add(new BirthdayPerson(birthday));
		}
	}
	
	/**
	 * This method calculates if any two people in the class shares a birthday.
	 * @return Returns a one when a match is found
	 */
	private int possibleBirthdays() {
		int currentPerson = 0;
		for(BirthdayPerson person: list) 
		{
			currentPerson++;
			for(int i = currentPerson; i < list.size(); i++) 
			{
				if(person.getBirthday() == list.get(i).getBirthday())
				{
					return 1;
				}
				
			}
		}
		return 0;
	}
	
	/**
	 * This method calculates the chance of any two people sharing a birthday in a class.
	 * @param num An int value that is the number of people in the class
	 * @return Returns a double value that represents a percentage.
	 */
	private double chanceOfSameBirthday(int num) {
		double chance = 1;
		int remainingdays = 364;
		
		for(int i = 1; i < num; i++) {
			chance = chance * ((double)remainingdays / 365);
			remainingdays--;
		}

		
		chance = 1 - chance;
		chance = chance * 100;
		return chance;
	}
	
	/**
	 * This method calls other methods to calculate the overall percentage of any two people sharing the same birthday
	 * in x amount of runs.
	 * @param people An int value of how many people are in the class.
	 * @param testcases An int value of how many times to run the trial.
	 * @return Returns a double value that represents a percentage.
	 */
	private double birthdayTrial(int people, int testcases) {
		int match = 0;
		for(int i = 0; i < testcases; i++) {
			makePerson(people);
			match += possibleBirthdays();
			
		}
		
		double result = (double) match / testcases;
		return result * 100;
	}
	
	
	/**
	 * This method is to test the Birthday program which involves asking the user on how many people are in the class and how many times to run.
	 */
	public void testBirthday() {
		System.out.print("How many people in your class?: ");
		int num = in.nextInt();
		System.out.format("%.2f percent", chanceOfSameBirthday(num));
		System.out.print("\nHow many trials you want to run?: ");
		int trials = in.nextInt();
		System.out.println("Here is the percentage of any 2 people sharing the same birthday in the class " + trials + " times: ");
		System.out.format("%.2f percent", birthdayTrial(num, trials));
		in.close();
		
	}
}

