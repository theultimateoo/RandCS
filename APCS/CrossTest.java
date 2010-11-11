import java.util.*;
import java.io.*;

public class CrossTest {

    public static void main(String[] args) {

	Crossword c = new Crossword(20, 20);

	c.addWord("HELLO", 0, 0, "DOWN");

	c.addWord("HAPLOID", 0, 0, "ACROSS");
	c.addWord("COMPUTER", 2, 11, "DOWN");

	c.addWord("CAT", 1, 10, "ACROSS");

	c.addWord("WOAH", 1, 19, "ACROSS");
	c.addWord("PARKING", 19, 4, "DOWN");

	c.addWord("ARK", 16, 5, "ACROSS");
	c.addWord("AHOY", 5, 17, "DOWN");
	c.addWord("AHOY", 17, 9, "ACROSS");
	c.addWord("ADVANTAGE", 1, 11, "ACROSS");
	c.addWord("INTERNAL", 1, 17, "ACROSS");
	c.addWord("BANTER", 6, 10, "DOWN");
	c.addWord("BEAGLE", 4, 11, "ACROSS");
	c.addWord("BASE", 7, 2, "DOWN");
	c.addWord("BALL", 7, 2, "ACROSS");
	c.addWord("LEFT", 9, 2, "DOWN");
	c.addWord("SAFE", 7, 4, "ACROSS");
	
	System.out.print(c);
    }
}
