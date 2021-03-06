import java.util.*;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    System.out.println("Welcome to Bingo. It is still a WIP. If the board has duplicates, make sure to rerun the program, but hopefully it does not. I am planning to add a feature where you can mark your numbers. Have Fun!");
    int[][] board = new int[4][4];
    ArrayList<Integer> Nums = new ArrayList<Integer>();
    createBoard(Nums, board);
    printBoard(board);
   
    
  }

public static ArrayList<Integer> createBoard(ArrayList<Integer> Nums, int[][] board)
{
	//checking Nums till it has no duplicates and the size is 16
  int index = 0;
  while(Nums.size() < 16)
  {
    Nums.add((int) (Math.random()*(100- 10)) + 10);
    Nums = removeDup(Nums);
  }
  for(int r = 0; r < board.length; r++)
  {
    for(int c = 0; c < board[r].length; c++)
    {
      board[r][c] = Nums.get(index);
      index++;
    }
  }
 
  return Nums;

}


//checks for duplicate numbers inside the ArrayList
public static ArrayList<Integer> removeDup(ArrayList<Integer> Nums) 
    { 
  
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




//prints the board
public static int[][] printBoard(int[][] board)
{
 for(int r = 0; r < board.length; r++)
    {
        for(int c = 0; c < board[r].length; c++)
        {
          System.out.print(board[r][c] + " | ");
        }
        System.out.println();
    }
    return board;
}


}