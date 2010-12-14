public class SuperArray{

  public static final int DEFAULT_SIZE = 5;
  String[] array;
  int number;
  int capacity;
  public SuperArray(){
    array = new String[DEFAULT_SIZE];
    number = 0;
    capacity = DEFAULT_SIZE;
  }
  public SuperArray(int a){
    array = new String[a];
    number = 0;
    capacity = a;
  }   
  public String toString(){
    String s = "";
    for(int i = 0; i < array.length; i++){
      s = s + " , " + array[i];
    }
    return s;
  }
  public void expand(int b){
    String[] array2 = new String[capacity + b];
    for(int i = 0; i < capacity; i++){
      array2[i] = array[i];
    }
    array = array2;
    capacity = capacity + b;
  }
  public void add(String t){
    if(array[capacity - 1] != null){
    expand(1);
    }
    array[number] = t;
    number++;
  }
  public String get(int a){
	
  }
  public static void main(String[] args){
    SuperArray c = new SuperArray();
    c.add("Hi");
    c.add("Bye");
    c.add("Hi");
    c.add("Bye");
    System.out.println(c);
    c.add("Hi");
    System.out.println(c);
    c.add("Bye");
    System.out.println(c);
  }
}
