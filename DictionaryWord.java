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

public class DictionaryWord {
	private final String word; // word that represents the search key for this dictionary word
	private final String meaning;   // The meaning of the word that this dictionary node defines
	private DictionaryWord leftChild;  // The leftChild of the the current WebPageNode
	private DictionaryWord rightChild; // The rightChild of the the current WebPageNode

	// The following should be the only constructor for this class
	// Creates a new dictionary word with the provided word and its meaning pair
	// Throws IllegalArgumentException when the word or meaning are either references to an empty
	// string or null references. The thrown exception should include a significant error message 
	// describing which of these problems was encountred.

	public DictionaryWord(String word, String meaning) {
		//check if word is null or empty
		if (word == null || word.isEmpty()) {
			throw new IllegalArgumentException("Word is empty or null.");
		}
		//check if meaning is null or empty
		if (meaning == null || meaning.isEmpty()) {
			throw new IllegalArgumentException("Meaning is empty or null.");
		}
		this.word = word;
		this.meaning = meaning;
		this.leftChild = null;
		this.rightChild = null;
	}


	// Getter for the left child of this dictionary word
	public DictionaryWord getLeftChild() {
		return this.leftChild;
	}

	// Setter for the left child of this dictionary word
	public void setLeftChild(DictionaryWord leftChild) {
		this.leftChild = leftChild;
	}

	// Getter for the right child of this dictionary word
	public DictionaryWord getRightChild() {
		return this.rightChild;
	}

	// Getter for the right child of this dictionary word
	public void setRightChild(DictionaryWord rightChild) {
		this.rightChild = rightChild;
	}

	// Getter for the word of this dictionary word
	public String getWord() {
		return this.word;
	}

	// Getter for the meaning of the word of this dictionary word
	public String getMeaning() {
		return this.meaning;
	} 

	// Returns a String representation of this DictionaryWord.
	// This String should be formatted as follows. "<word>: <meaning>"
	// For instance, for a dictionaryWord that has the String "Awesome"
	// for the instance field word and the String "adj. Inspiring awe; dreaded."
	// as value for meaning field, the String representing that dictionaryWord is
	// "Awesome: adj. Inspiring awe; dreaded."
	public String toString() { 
		return this.getWord() + ": " + this.getMeaning();
	}
}
