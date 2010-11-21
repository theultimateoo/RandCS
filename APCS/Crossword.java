import java.util.*;

public class Crossword{

    public static final int ROW_INIT = 3;
    public static final int COLUMN_INIT = 6;
    public static final char CHAR_INIT = ' ';
    public static final int NUM_INIT = 0;
    char[][] array;
    boolean[][] arraySpaces;//for extra feature: this will tell which spaces are conflict points
    int[][] numberGrid;
    boolean[][] starts;//for numberGrid - boolean array of true/false starts of words
    public Crossword(){
	array = new char[ROW_INIT][COLUMN_INIT];
	arraySpaces = new boolean[ROW_INIT][COLUMN_INIT];
	numberGrid = new int[ROW_INIT][COLUMN_INIT];
	starts = new boolean[ROW_INIT][COLUMN_INIT];
	for(int i = 0; i < ROW_INIT; i++){
	    for(int j = 0; j < COLUMN_INIT; j++){
		array[i][j] = CHAR_INIT;
		arraySpaces[i][j] = false;
		numberGrid[i][j] = NUM_INIT;
		starts[i][j] = false;
	    }
	}
    }

    public Crossword(int rows, int cols){
	int r = rows;
	int c = cols;
	array = new char[r][c];
	arraySpaces = new boolean[r][c];
	numberGrid = new int[r][c];
	starts = new boolean[r][c];
	for(int i = 0; i < r; i++){
	    for(int j = 0; j < c; j++){
		array[i][j] = CHAR_INIT;
		arraySpaces[i][j] = false;
		numberGrid[i][j] = NUM_INIT;
		starts[i][j] = false;
	    }
	}
    }

    public String toString(){
	String s;
	s = "";
	for(int i=0; i < array.length; i++ ){
	    for(int j=0; j<array[i].length; j++) {
		s = s + array[i][j];
	    }
	    s = s + '\n';
	}
	return s;
    }

    public void addWord(String word, int acrosspos, int downpos, String orientation){
	
        int b = array.length; //length of column 
	int c = acrosspos; //starting row position 
	int d = downpos; //starting column position 
	if(c <= array.length - 1){
	    //corrects for the small case in which someone sets acrosspos as 100 with a 2x2 array (arbitrary numbers). This allows you to do array[100].length only if c <= array.length -1
	    int a = array[acrosspos].length; //length of row
	    String w = word; //inputted word
	    boolean conflict = false;//test if the word you want to put in conflicts with the preexisting word
	    
	    if (orientation.equals("DOWN")){//If the user wishes to insert a word vertically
		if(c >= 0 && c < a && d >= 0 && d < b && w.length() <= b - c){
		    /*Conditions:
		     *Is word's starting position inside the grid? [1-4]
		     *Does the word fit inside the grid? ((length of row - 1) - (position) + 1) [5]
		     *Note: Going by array convention: 0 to columns - 1, 0 to rows - 1 
		     */
		    
		    int k = 0;//k is our counter for the word's character position - initialize it to zero
		    
		    for(int i = c; k < w.length(); i++){//while k < word length, start from the starting position of the word and increase i by 1 each time
			if ((array[i][d] != CHAR_INIT && array[i][d] != w.charAt(k)) || arraySpaces[i][d] == true){
			    /*Conditions:
			     *For each character, does the character equal the initial character or the character in the position?
			     *Does the corresponding boolean array say that there was a space there formed by another word?
			     */
			    conflict = true; //if so, there is a conflict
			}
			k++;
		    }
		    
		    k = 0;
		    
		    if (conflict == false){
			starts[c][d] = true;
			starts[a - (c + w.length() - 1) - 1][b - d - 1] = true;
			if (c >= 1){
			    arraySpaces[c-1][d] = true;
			}
			if (w.length()+1 <= b - c){
			    arraySpaces[c+w.length()][d] = true;
			    
			    for(int i = c; k < w.length(); i++){
				array[i][d] = w.charAt(k); //set (i,d)=the kth character of the string, starting with 0. d is constant. changing i changes the row.
				k++;//move onto the next character
				array[b - i - 1][a - d - 1] = '*';
			    }
			}	    
		    }
		    
		    //if added word successful, thus add letter at (a,b), given array(X,Y) - (X - a - 1, Y - b - 1) has to be a *.
		    //if word.length < array length in direction of orientation - pos, then allow
		}
	    }

	    if (orientation.equals("ACROSS")){
		if(c >= 0 && c < a && d >= 0 && d < b && w.length() <= a - d ){
		    //First 4 if conditions test to see that the word is within the grid
		    //Last condition tests to see if the word is short enough to fit in the grid.
		    //Note: Going by array convention: 0 to columns - 1, 0 to rows - 1
		    int k = 0;//initialize k to equal 0

		    for(int i = d; k < w.length(); i++){
			if ((array[c][i] != CHAR_INIT && array[c][i] != w.charAt(k)) || arraySpaces[c][i] == true){
			    conflict = true;
			}
			k++;
		    }
		
		    k = 0;
	
		    if (conflict == false){
			starts[c][d] = true;    
			starts[a - c - 1][b - (d + w.length() - 1) - 1] = true;
			if (d >= 1){
			    arraySpaces[c][d-1] = true;
			}
			if (w.length()+1 <= a - d){
			    arraySpaces[c][d+w.length()] = true;
			}
			for(int i = d; k < w.length(); i++){
			    array[c][i] = w.charAt(k);//set (c,i)=the kth character of the string, starting with 0
			    k++;//move onto the next character
			    array[a - c - 1][b - i - 1] = '*';
			}
		    }    
		}	
	    }
	}
    }
	public void setNumberGrid(){
	    for (int i=0; i < numberGrid.length; i++){
		for(int j=0; j < numberGrid[i].length; j++){
		    if (array[i][j] == CHAR_INIT){
			numberGrid[i][j] = 0;
		    }
		    else {
			numberGrid[i][j] = -1;
		    }
		    if (starts[i][j] == true){//this overwrites the step before, if this condition is indeed true
			numberGrid[i][j] = -2;
		    }
		}
	    }
	    int k = 1; //Counter for -2's
	    for(int i=0; i < numberGrid.length; i++){
		for(int j=0; j < numberGrid[i].length; j++){
		    if(numberGrid[i][j] == -2){
			numberGrid[i][j] = k;
			k++;
		    }
		}
	    }
	}

	public void printNumberGrid(){
	    for(int i=0; i < numberGrid.length; i++){
		for(int j=0; j < numberGrid[i].length; j++){
		    if(numberGrid[i][j] == -1){
			System.out.print("  ");
		    }
		    else if(numberGrid[i][j] == 0){
			System.out.print("##");
		    }
		    else if(numberGrid[i][j] > 0 && numberGrid[i][j] < 10){
			System.out.print(numberGrid[i][j] + " ");
		    }
		    else{
			System.out.print(numberGrid[i][j]);
		    }
		}
		System.out.println();
	    }
	}

	public static void main(String[] args){
	    //Crossword cr = new Crossword();
	    Crossword cq = new Crossword();
	    //System.out.print(cr);
	    cq.addWord("wow",1,1,"DOWN");
	    cq.addWord("water",3,3,"ACROSS");
	    cq.addWord("",4,4, "DOWN");
	    System.out.print(cq);
	}
    }
