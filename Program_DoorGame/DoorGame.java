import java.util.ArrayList;
import java.util.Random;
/**
 * Date: March 1-2023
 * This class is a simulation of the Monty Hall Game where it will be played by the program.
 * @author Brandon_Pacheco
 * @version 1.0
 *
 */
public class DoorGame {
	/**
	 * This is a global ArrayList.
	 */
	private ArrayList<DoorPrize> doorList = new ArrayList<>();
	/**
	 * This is a global Random.
	 */
	private Random rand = new Random();
	/**
	 * This is a global int variable.
	 */
	private int rounds = 10000;
	
	/**
	 * This method will load the 3 doors with a car and two goats.
	 */
	private void loadDoor() {
		if(!doorList.isEmpty()) {
			doorList.clear();
		}
		
		while(true) {
			
			int load = rand.nextInt(3);
			if(!doorList.contains(DoorPrize.values()[load])) {
				doorList.add(DoorPrize.values()[load]);
			}
			
			if(doorList.size() == 3) {
				return;
			}
		}
	}
	
	/**
	 * This method plays the game without switching your door.
	 * @return Returns a double value that is the percentage of getting the car.
	 */
	private double playGameWithoutSwitching() {
		int correctGuess = 0;
		for(int i = 0; i < rounds; i++ ) 
		{
			loadDoor();
			DoorPrize pickedDoor = doorList.get(rand.nextInt(3));
			if(pickedDoor == DoorPrize.CAR) 
			{
				correctGuess++;
			}
		}
		//dont know what to do with mod
		double result = (double)correctGuess / rounds;
		System.out.println("total wins: " + correctGuess);
		return result * 100;
	}
	
	/**
	 * This method plays the game and it switches the door after a goat is revealed.
	 * @return Returns a double value that is the percentage of getting the car.
	 */
	private double playGameAndSwitching() {
		int correctGuess = 0;
		
		for(int i = 0; i < rounds; i++ ) 
		{
			loadDoor();
			DoorPrize pickedDoor = doorList.get(rand.nextInt(3));
			DoorPrize prize = DoorPrize.CAR;
			DoorPrize wrongDoor;
			while(true) {
				wrongDoor = doorList.get(rand.nextInt(3));
				if(wrongDoor != pickedDoor && wrongDoor != prize) 
				{
					doorList.remove(wrongDoor);
					break;
				}
			}
			
			while(true) {
				int newGuess = rand.nextInt(doorList.size());
				if(doorList.get(newGuess) != pickedDoor ) 
				{
					pickedDoor = doorList.get(newGuess);
					break;
				}
			}
			
			
			if(pickedDoor == DoorPrize.CAR) 
			{
				correctGuess++;
			}
			
		}
		//dont know what to do with mod
		double result = (double)correctGuess / rounds;
		System.out.println("total wins: " + correctGuess);
		return result * 100;
	}
	
	/**
	 * This method tests the Door Game.
	 */
	public void testDoorGame() {
		System.out.println("Playing the door game without switching your door"
				+ " 10,000 times: ");
		System.out.format("%.2f percent.\n", playGameWithoutSwitching());
		
		System.out.println("Playing the door game and you switch your choice"
				+ " 10,000 times: ");
		System.out.format("%.2f percent.\n", playGameAndSwitching());
		
	}
	
}


/**
 * This is an enumeration set that includes a car, and two goats.
 * @author Brandon_Pacheco
 *
 */
enum DoorPrize{
	CAR, GOATONE, GOATTWO;
}
