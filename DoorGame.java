import java.util.ArrayList;
import java.util.Random;
public class DoorGame {
	private ArrayList<DoorPrize> doorList = new ArrayList<>();
	private Random rand = new Random();
	private int rounds = 10000;
	
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
		return result;
	}
	
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
		return result;
	}
	
	public void testDoorGame() {
		System.out.println("Playing the door game without switching your door"
				+ " 10,000 times: " + playGameWithoutSwitching());
		
		System.out.println("Playing the door game and you switch your choice"
				+ " 10,000 times: " + playGameAndSwitching());
		
	}
	
}


enum DoorPrize{
	CAR, GOATONE, GOATTWO;
}
