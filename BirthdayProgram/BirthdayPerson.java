/**
 * Date: March 1-2023
 * This class represents a person with a birthday. This will help with the Birthday class.
 * @author Brandon_Pacheco
 * @version 1.0
 *
 */
public class BirthdayPerson {

	/**
	 * A variable that represents the birthday of a person in 365 format.
	 */
	private int birthday;
	
	/**
	 * This constructor constructs a BirthdayPerson object and assigns a birthday to it
	 * @param birthday An int value that is passed in which is the birthday. 
	 */
	public BirthdayPerson(int birthday) {
		this.birthday = birthday;
		
	}

	/**
	 * This method is a getter method which returns the birthday of this person's birthday
	 * @return birthday An int value which represents the birthday of this person.
	 */
	public int getBirthday() {
		return birthday;
	}
	
}

