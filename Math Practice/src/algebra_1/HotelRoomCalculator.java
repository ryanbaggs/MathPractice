/**
 * 
 */
package algebra_1;

import menu.MenuCreator;

/**
 * This is a hotel room calculator. It finds the number of blocks that will 
 * need to be purchased and how much it will cost. 
 * 
 * @author Ryan Baggs
 * @date Oct 16, 2021
 */
public class HotelRoomCalculator extends MenuCreator{
	
	private static final int BLOCK_RATE = 500;
	private static final int BLOCK_SIZE = 4;
	
	
	public HotelRoomCalculator() {
		String[] menuOptions = {"Enter 0 to calculate number of rooms", 
		"Enter 1 to exit"};

		setMenuOptions(menuOptions);
		
		// Call displayMenu.
		displayMenu();
	}

	@Override
	protected void selectionCases(int option) {
		super.selectionCases(option);
		
		switch(option) {
			case 0:
				calculateRooms();
				break;
			case 1:
				exit();
				break;
			default:
				invalidInput();
		}
	}
	
	private void calculateRooms() {
		/**
		 * This is based off an algebra equation:
		 * 9B + 15 >= 50
		 * 9B is the number of blocks.
		 * 15 is the initial number of rooms purchased.
		 * 50 is the number of people who need rooms.
		 */
		
		// Inform user that there are 4 rooms to a block that needs to be 
		// purchased.
		System.out.println("There are " + BLOCK_SIZE + " rooms to a block "
				+ "which is $" + BLOCK_RATE + " each block.");
		System.out.println("You can only purchase blocks of rooms.");
		
		// Get the number of people.
		System.out.println("Enter the number of people who will need rooms.");
		int numberOfPeople = getInt();
		
		// Get how many people have rooms already.
		System.out.println("Enter the number of people who already have a room.");
		int haveRooms = getInt();
		
		// Determine how many still need rooms by subtracting haveRooms from numberOfPeople.
		int needRooms = numberOfPeople - haveRooms;
		
		/**
		 *  Determine if there are any remainder of people who do not fill an 
		 *  entire block. If not then no extra block of rooms needed, if so 
		 *  then add an extra block of rooms.
		 */
		int remainder = (needRooms % BLOCK_SIZE) > 0 ? 1 : 0;
		
		// Determine the number of blocks needed.
		int blocks = (needRooms / BLOCK_SIZE) + remainder;
		
		// Print the number of blocks and the total cost.
		System.out.println("The number of blocks is: " + blocks);
		System.out.println("The total cost is: " + (blocks * BLOCK_RATE));
	}
}
