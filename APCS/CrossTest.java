import java.util.*;
import java.io.*;

public class CrossTest {

    public static void main(String[] args) {

	Crossword c = new Crossword(20, 20);

	c.addWord("HELLO", 0, 0, "ACROSS");

	c.addWord("HAPLOID", 0, 0, "DOWN");
	c.addWord("COMPUTER", 2, 11, "ACROSS");

	c.addWord("CAT", 1, 10, "DOWN");

	c.addWord("WOAH", 1, 19, "DOWN");
	c.addWord("PARKING", 19, 4, "ACROSS");

	c.addWord("ARK", 16, 5, "DOWN");
	c.addWord("AHOY", 5, 17, "ACROSS");
	c.addWord("AHOY", 17, 9, "DOWN");
	c.addWord("ADVANTAGE", 1, 11, "DOWN");
	c.addWord("INTERNAL", 1, 17, "DOWN");
	c.addWord("BANTER", 6, 10, "ACROSS");
	c.addWord("BEAGLE", 4, 11, "DOWN");
	c.addWord("BASE", 7, 2, "ACROSS");
	c.addWord("BALL", 7, 2, "DOWN");
	c.addWord("LEFT", 9, 2, "ACROSS");
	c.addWord("SAFE", 7, 4, "DOWN");
	c.setNumberGrid();
	System.out.print(c);
	c.printNumberGrid();
    }
}
