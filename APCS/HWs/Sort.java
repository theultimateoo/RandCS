import java.io.*;
import java.util.*;

public class Sort {

    public static int DEFAULT_SIZE = 1000;
    int swaps;
    int comps;

    private int[] list;
  
    public Sort() {
	list = new int[ DEFAULT_SIZE ];
	populate();
	swaps = 0;
	comps = 0;
    }

    public Sort(int size) {
	list = new int[size];
	populate();
    }

    public void populate() {

	Random r = new Random();
	for (int i=0; i<list.length; i++)
	    list[i] = r.nextInt() % list.length;
    }

    //copies the data from Sort s to THIS
    public void duplicate(Sort s, int size) {

	for (int i=0; i<size; i++)
	    list[i] = s.list[i];
    }

    public int size() {
	return list.length;
    }

    public String toString() {
	String s = "";
	for (int i=0; i<list.length - 1; i++)
	    s = s + list[i] + ", ";
	return s + list[list.length-1];
    }

    public boolean isSorted() {
	for (int i=0; i<list.length - 1; i++)
	    if (list[i] > list[i+1])
		return false;
	return true;
    }
   
    public void swap(int a, int b) {
	int c = list[a];
	list[a] = list[b];
	list[b] = c;
	swaps++;
    }

    public long bubble() {

	for(int i=0; i < list.length - 1; i++) {
	    for(int j=list.length - 1; j > i; j--) {
		comps++;
		if ( list[j] < list[j-1] )
		    swap(j, j-1);
	    }//end loop: j
	}//end loop: i
	return System.currentTimeMillis();
    }

    public long bubble2() {

	for(int i=0; i < list.length - 1; i++) {

	    boolean sorted = true;
	    for(int j=list.length - 1; j > i; j--) {
		comps++;
		if ( list[j] < list[j-1] ) {
		    swap(j, j-1);
		    sorted = false;
		} //end if
	    } //end loop: j
	    if ( sorted ) 
		return System.currentTimeMillis();
	} //end loop: i
	return System.currentTimeMillis();
    }

    public long selection() {
	
	int min;

	for(int i=0; i < list.length; i++) {
	    min = i;
	    for(int j=i+1; j < list.length; j++) {
		comps++;
		if ( list[j] < list[min] )
		    min = j;
	    }//end loop: j
	    swap(i, min);
	}//end loop: i
	return System.currentTimeMillis();
    }

    public long insertion() {

	int t, pos;
	for (int i=1; i<list.length; i++) {
	    
	    pos = i;
	    t = list[pos];

	    while( pos > 0 && t < list[pos-1] ) {
		list[pos] = list[pos - 1];
		pos--;
	    }//end loop: while
	    list[pos] = t;
	    comps++;
	}//end loop: i
	swaps = comps / 3;

	return System.currentTimeMillis();
    }

    public void printStats(){
	System.out.println("Swaps: " + swaps + " Comps: " + comps);
    }

    public static void main(String[] args) {
	
	Sort s = new Sort(1000);	
	Sort t = new Sort(1000);
	Sort u = new Sort(1000);
	Sort v = new Sort(1000);	
	s.duplicate(t, s.size() ); //now s and t have the same sets to compare efficiency
	u.duplicate(t, u.size() );
	v.duplicate(t, v.size() );
	System.out.println(s.bubble());	
	s.printStats();
	System.out.println(t.bubble2());
	t.printStats();
	System.out.println(u.selection());
	u.printStats();
	System.out.println(v.insertion());
	v.printStats();
    }  
}
