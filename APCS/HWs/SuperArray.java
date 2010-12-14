public class SuperArray{
	public static final int DEFAULT_SIZE = 5;
	String array[];
	int elements;
	int arraySize;
	public SuperArray(){
		array = new String[DEFAULT_SIZE];
		elements = 0;
		arraySize = DEFAULT_SIZE;
	}
	public SuperArray(int a){
		array = new String[a];
		elements = 0;
		arraySize = a;
	}
	public String toString(){
		String s = "";
		for(int i = 0; i < array.length; i++){
			s = s + array[i];
		}
		return s;
	}
	public static void main(String[] args){
		SuperArray s = new SuperArray(6);
		System.out.println(s);
	}
}
