//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Dictionary Using BST
// Files:   DictionaryBst.java, DictionaryWord.java, Dictionary.java, DictionaryTests.java
// Course:   CS300       
//
// Author: Alex Ionkov       
// Email:  ionkov@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Taran Bedi
// Partner Email:   tbedi@wisc.edu
// Lecturer's Name: Mouna Kacea
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.  If you received no outside help from either type of 
// source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryDriver {
	/**
	 * main driver method
	 * @param args used for input
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DictionaryBST dictionary = new DictionaryBST();
		while (true) {
			System.out.print("=========================== Dictionary ============================\n" + "Enter one of the following options:\n" + "[A <word> <meaning>] to add a new word and its definition in the dictionary\n" + 
					"[L <word>] to search a word in the dictionary and display its definition\n" + "[G] to print all the words in the dictionary in sorted order\n" + "[S] to get the count of all words in the dictionary\n" + 
					"[H] to get the height of this dictionary implemented as a binary search tree\n" + "[Q] to quit the program\n" + "======================================================================\n" + 
					"\n" + "Please enter your command: ");
			String[] line = sc.nextLine().split(" ", 3);
			switch (line[0].toUpperCase().charAt(0)) {
			case 'A':
				try {
					dictionary.addWord(line[1], line[2]);
				} catch (IllegalArgumentException e) {
					System.out.println("WARNING: Syntax Error for [A <word> <meaning>] command line.");
				}
				break;
			case 'L':
				try {
					String meaning = dictionary.lookup(line[1]);
					if (meaning == "" || meaning == null) {
						System.out.println("No definition found for the word " + line[1]);
					}
					else {
						System.out.println(line[1] + ": " + meaning);
					}
				}
				catch (IllegalArgumentException e) {
					System.out.println("WARNING: Syntax Error");
				}
				break;
			case 'G':
				try {
					ArrayList<String> allWords = dictionary.getAllWords();
					if (allWords.isEmpty())
						System.out.println("Dictionary is empty.");
					else
						System.out.println(dictionary.toString());
				}
				catch (IllegalArgumentException e) {
					System.out.println("WARNING: Syntax Error");
				}
				break;
			case 'S':
				System.out.println(dictionary.size());
				break;
			case 'H':
				System.out.println(dictionary.height());
				break;
			case 'Q':
				System.out.println("============================== END ===================================\n");
				sc.close();
				break;
			default:
				System.out.println("WARNING: Unrecognized command.");
				break;
			}
			System.out.println();
		}
	}
}
