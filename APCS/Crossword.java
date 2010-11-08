//KEVIN PENG

import java.util.*;

public class Crossword{

    public static final int ROW_INIT = 3;
    public static final int COLUMN_INIT = 6;

    char[][] array;

    public Crossword(){
	array = new array[ROW_INIT][COLUMN_INIT];
	for(int i = 0; i < ROW_INIT; i++){
	    for(int j = 0; j < COLUMN_INIT; j++){
		array[i][j] = ' ';
	    }
	}
    }

    public Crossword(int rows, int cols){
	array = new array[rows][cols];
	for(int i = 0; i < ROW_INIT; i++){
	    for(int j = 0; j < COLUMN_INIT; j++){
		array[i][j]= ' ';
	    }
	}
    }

    public String toString(){

    }
    public addWord(String word){
	//if added word successful, thus add letter at (a,b), given array(X,Y) - (X - a - 1, Y - b - 1) has to be a *.
	//if word.length < 


    }

}
