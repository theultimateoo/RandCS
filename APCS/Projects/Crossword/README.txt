Jeffrey Yan and Kevin Peng

This Java program simulates a crossword. 
All features required on the CS website have been implemented.

============================================================================================================================================================
There aren't any bugs to be expected, so we will provide some of our recent bug fixes:
-Fixed the "Out of Bounds" error caused in a non-square crosswords by an incorrect mathematical formula in Crossword.java
-Fixed the error that allowed you to add words with an end touching a preexisting word 
(i.e. 
DUDE
 H
 I
)
"HI" no longer appears, even if it is added second.

============================================================================================================================================================
Instructions for running the code:
1. Edit CrossTest.java by changing the size of the crossword to any size. 
2. Edit CrossTest.java by changing the words, starting position, and orientation (either "ACROSS" or "DOWN"), but keep in the form of: c.addWord("WORD", row #, column #, orientation)
3. Compile CrossTest.java and Crossword.java.
4. Run CrossTest.class.
