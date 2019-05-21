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

public interface Dictionary {
	// checks whether the dictionary is empty or not
	public boolean isEmpty();

	// adds this word definition (word and the provided meaning) to the dictionary
	// Returns true if the word was successfully added to this dictionary
	// Returns false if the word was already in the dictionary
	// Throws IllegalArgumentException if either word or meaning is null or an empty
	// String
	public boolean addWord(String word, String meaning);

	// Returns the meaning of the word s if it is present in this dictionary
	// Throws a NoSuchElementException if the word s was not found in this dictionary  
	public String lookup(String s);

	// Returns the number of words stored in this dictionary
	public int size();
}
