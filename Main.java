import java.util.*;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(
				"Welcome to Bingo. If the board has duplicates, make sure to rerun the program, but hopefully it does not. Have Fun!");
		int[][] board = new int[4][4];
		ArrayList<Integer> Nums = new ArrayList<Integer>();
		createBoard(Nums, board);
		printBoard(board);
		while (true) {
			System.out.println("Enter in picked numbers and it will be marked in as 0. Type in quit to exit the game");
			String userInput = input.nextLine();
			if (userInput.equals("quit")) {
				System.out.println("Thank you for playing!");
				break;
			}
			if(checkInput(userInput) == false)
			{
				continue;
			}
			int number = Integer.parseInt(userInput);
			markBoard(number, board);
			printBoard(board);
			
			

		}

	}

	public static ArrayList<Integer> createBoard(ArrayList<Integer> Nums, int[][] board) {
		// checking Nums till it has no duplicates and the size is 16
		int index = 0;
		while (Nums.size() < 16) {
			Nums.add((int) (Math.random() * (100 - 10)) + 10);
			Nums = removeDup(Nums);

		}
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				board[r][c] = Nums.get(index);
				index++;
			}
		}

		return Nums;

	}

	// checks for duplicate numbers inside the ArrayList
	public static ArrayList<Integer> removeDup(ArrayList<Integer> Nums) {

		// Create a new ArrayList
		ArrayList<Integer> newList = new ArrayList<Integer>();

		// Traverse through the first list
		for (Integer element : Nums) {

			// If this element is not present in newList
			// then add it
			if (!newList.contains(element)) {

				newList.add(element);
			}
		}

		// return the new list
		return newList;
	}

	// prints the board
	public static int[][] printBoard(int[][] board) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				System.out.print(board[r][c] + " | ");
			}
			System.out.println();
		}
		return board;
	}

	public static void markBoard(int number, int[][] board)
	{
		for(int r = 0; r < board.length; r++)
		{
			for(int c = 0; c < board[r].length; c++)
			{
				if(board[r][c] == number)
				{
					board[r][c] = 0;
				}
			}
		}
	}

	public static boolean checkInput(String userInput)
	{
			try {
				int stringToInt = Integer.parseInt(userInput);
			} catch (NumberFormatException ex) {
				return false;
			}
			return true;

	}



}