import java.io.*;
import java.util.*;

public class Sort {
  
  public static int DEFAULT_SIZE = 1000;
  
  private int[] list;
  
  public Sort() {
    list = new int[ DEFAULT_SIZE ];
    populate();
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
  
  public void copy(Sort s, int size) {
    
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
  }
  
  public void bubble() {
    
    for(int i=0; i < list.length - 1; i++) {
      for(int j=list.length - 1; j > i; j--) {
        
        if ( list[j] < list[j-1] )
          swap(j, j-1);
      }//end loop: j
    }//end loop: i
  }
  
  public void bubble2() {
    
    for(int i=0; i < list.length - 1; i++) {
      
      boolean sorted = true;
      for(int j=list.length - 1; j > i; j--) {
        
        if ( list[j] < list[j-1] ) {
          swap(j, j-1);
          sorted = false;
        } //end if
      } //end loop: j
      if ( sorted ) 
        return;
    } //end loop: i
  }

  public static void main(String[] args) {
    
    Sort s = new Sort(25);
    
    System.out.println(s);
    s.selection();
    System.out.println(s);
  }  
  
}