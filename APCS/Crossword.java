import java.util.*;

public class Crossword{

    public static final int ROW_INIT = 3;
    public static final int COLUMN_INIT = 6;
    public static final char CHAR_INIT = '-';
    char[][] array;

    public Crossword(){
	array = new char[ROW_INIT][COLUMN_INIT];
	for(int i = 0; i < ROW_INIT; i++){
	    for(int j = 0; j < COLUMN_INIT; j++){
		array[i][j] = CHAR_INIT;
	    }
	}
    }

    public Crossword(int rows, int cols){
	int r = rows;
	int c = cols;
	array = new char[r][c];
	for(int i = 0; i < r; i++){
	    for(int j = 0; j < c; j++){
		array[i][j]= CHAR_INIT;
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
	int a = array[acrosspos].length; //length of row
        int b = array.length; //length of column
	int c = acrosspos; //starting position in row
	int d = downpos; //starting position in column
	String w = word;
	boolean conflict = false;//test if the word you want to put in conflicts with the preexisting word
	
	if (orientation.equals("DOWN")){
	    if(c >= 0 && c < a && d >= 0 && d < b && w.length() <= b - d){
		//First 4 if conditions test to see that the word's starting position is within the gird
		//Last condition tests to see if the word is short enough to fit in the grid. ((length of row - 1) - (position) + 1)
		//Note: Going by array convention: 0 to columns - 1, 0 to rows - 1
	
		int k = 0;//initialize k to equal 0

		for(int i = c; k < w.length(); i++){
			if (array[i][d] != CHAR_INIT && array[i][d] != w.charAt(k)){
				conflict = true;
			}
			k++;
		}
		
		k = 0;
		
		if (conflict == false){
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

	if (orientation.equals("ACROSS")){
	    if(c >= 0 && c < a && d >= 0 && d < b && w.length() <= a - c ){
		//First 4 if conditions test to see that the word is within the grid
		//Last condition tests to see if the word is short enough to fit in the grid.
		//Note: Going by array convention: 0 to columns - 1, 0 to rows - 1
		int k = 0;//initialize k to equal 0

		for(int i = d; k < w.length(); i++){
			if (array[c][i] != CHAR_INIT && array[c][i] != w.charAt(k)){
				conflict = true;
			}
			k++;
		}
		
		k = 0;
	
		if (conflict == false){
			for(int i = d; k < w.length(); i++){
				array[c][i] = w.charAt(k);//set (c,i)=the kth character of the string, starting with 0
				k++;//move onto the next character
				array[a - c - 1][b - i - 1] = '*';
			}
		}
		    
	    }
		
	}

    }
	public static void main(String[] args){
	    //Crossword cr = new Crossword();
	    Crossword cq = new Crossword(10,10);
	    //System.out.print(cr);
	    cq.addWord("wow",1,1,"DOWN");
	    cq.addWord("water",3,3,"ACROSS");
	    cq.addWord("",4,4, "DOWN");
	    System.out.print(cq);
	}


}
