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
	s = array[0];
    for(int i = 1; i < array.length; i++){
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
  public void add(String t, int a){
    if(a >= 0 && a < array.length){
    	while(array[a] != null){
    	  a++;
    	}
    	if(a >= array.length){
		expand(1);
    		array[a] = t;
    	}
	array[a] = t;
    }
  }
  public void remove(int a){
	if(a >= 0 && a < array.length){
		for(int i = a; i < array.length - 1; i++){
			array[a] = array[a+1];
		}
		array[array.length - 1] = null;
	}
  }

  public String set(int a, String t){
	if(a < 0 || a >= array.length){
		return null;
	}
	else{
		String s;
		s = array[a];
		array[a] = t;
		return s;
	}
  }
  public String get(int a){
	if(a >= 0 && a < array.length){
		return array[a];
	}
	else{
		return null;
	}
  }
  public static void main(String[] args){
    SuperArray c = new SuperArray();
    c.add("Hi", 3);
    c.set(4, "Bye");
    String t = c.get(4); 
    c.remove(3);
   System.out.println(c);
	System.out.println(t);
  }
}
