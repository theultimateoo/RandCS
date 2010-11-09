import java.util.*;

public class Crossword{

    public static final int ROW_INIT = 3;
    public static final int COLUMN_INIT = 6;

    char[][] array;

    public Crossword(){
	array = new char[ROW_INIT][COLUMN_INIT];
	for(int i = 0; i < ROW_INIT; i++){
	    for(int j = 0; j < COLUMN_INIT; j++){
		array[i][j] = '-';
	    }
	}
    }

    public Crossword(int rows, int cols){
	int r = rows;
	int c = cols;
	array = new char[r][c];
	for(int i = 0; i < r; i++){
	    for(int j = 0; j < c; j++){
		array[i][j]= '-';
	    }
	}
    }

    /*    public String toString(){

	  }*/
/*    public void addWord(String word, int acrosspos, int downpos, String orientation){
	int a = array[acrosspos].length;
        int b = array[downpos].length;
	int c = acrosspos;
	int d = downpos;
	String w = word;

	if (orientation.equals("ACROSS")){
	    if(c >= 0 && c < b && d >= 0 && d < a && w.length() <= b ){
		//First 4 if conditions test to see that the word is within the grid
		//Last condition tests to see if the word is short enough to fit in the grid.
		//Note: Going by array convention: 0 to columns - 1, 0 to rows - 1
	
		int k = 0;//initialize k to equal 0
		for(int i = c; i < w.length(); i++){
		    array[i][d] = w.charAt(k);//set (i,j)=the kth character of the string, starting with 0
		    k++;//move onto the next character
		    array[b - i - 1][a - d - 1] = '*';
		}
		    
	    }
		
	//if added word successful, thus add letter at (a,b), given array(X,Y) - (X - a - 1, Y - b - 1) has to be a *.
	//if word.length < array length in direction of orientation - pos, then allow
	}
    }*/
	public static void main(String[] args){
	    Crossword cr = new Crossword();
	    Crossword cq = new Crossword(3,5);
	}


}
