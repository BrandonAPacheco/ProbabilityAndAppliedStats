import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Birthday {
	private Random rand = new Random();
	private Scanner in = new Scanner(System.in);
	private ArrayList<Person> list = new ArrayList<>();
	
	public void makePerson(int count) {
		
		if(!list.isEmpty()) {
			list.clear();
		}
		for(int i = 0; i < count; i++) 
		{
			int birthday = rand.nextInt(365)+ 1;
			list.add(new Person(birthday));
		}
	}
	
	public int possibleBirthdays() {
		int currentPerson = 0;
		for(Person person: list) 
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
	
	public double chanceOfSameBirthday(int num) {
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
	
	public double birthdayTrial(int people, int testcases) {
		int match = 0;
		for(int i = 0; i < testcases; i++) {
			makePerson(people);
			match += possibleBirthdays();
			
		}
		
		double result = (double) match / testcases;
		return result;
	}
	
	
	public void testBirthday() {
		System.out.print("How many people in your class?: ");
		int num = in.nextInt();
		System.out.format("%.2f percent", chanceOfSameBirthday(num));
		System.out.print("\nHow many trials you want to run?: ");
		int trials = in.nextInt();
		System.out.println("\nHere is the ratio of any 2 people sharing the same birthday in your class " + trials + " times: " + birthdayTrial(num, trials));
		in.close();
		
	}
}

