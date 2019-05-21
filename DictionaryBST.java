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
import java.util.NoSuchElementException;

public class DictionaryBST implements Dictionary {
	//initialize root of the dictionary
	private DictionaryWord root;

	// This should be the only constructor of this class. 
	// Creates an empty dictionaryBST.
	public DictionaryBST() {
		//set index/root to null
		this.root = null;
	}

	// Methods defined in the Dictionary interface
	public boolean isEmpty() {
		//determine whether dict is empty
		return this.root == null;
	}

	/**
	 * calls lookupHelper and returns its value
	 */
	public String lookup(String s) { 
		return lookupHelper(s, this.root);
	}

	/**
	 * Recursive helper method to lookup a word s in the subtree rooted at current
	 * 
	 * @param s String that represents a word
	 * @param current pointer to the current DictionaryWord within this dictionary
	 * @return the meaning of the word s if it is present in this dictionary
	 * @throws NoSuchElementException if s is not found in this dictionary
	 */
	private String lookupHelper(String s, DictionaryWord current) {
		//throw exception when current is null
		if (current == null) {
			throw new NoSuchElementException("Didn't find a matching word.");
		}
		//if it matchs, return the meaning
		else if (s.compareToIgnoreCase(current.getWord())== 0) {
			return current.getMeaning();
		}
		//else then go down the left side first
		else if (s.compareToIgnoreCase(current.getWord()) < 0) {
			return lookupHelper(s, current.getLeftChild());
		}
		//and then the right side
		else {
			return lookupHelper(s, current.getRightChild());
		}
	}
	/**
	 * calls sizeHelper and returns its value
	 */
	public int size(){
		return sizeHelper(this.root);
	}
	
	/**
	 * Recursive helper method that returns the number of dictionary words stored in 
	 * the subtree rooted at current
	 * 
	 * @param current current DictionaryWord within this dictionaryBST
	 * @return the size of the subtree rooted at current
	 */
	private static int sizeHelper(DictionaryWord current) {
		int size = 0;

		//base case
		if(current == null) {
			return 0;
		}
		//add the lower children and itself recursively
		size += sizeHelper(current.getLeftChild());
		size += sizeHelper(current.getRightChild());
		size++;

		return size;
	}
	
	/**
	 * Computes and returns the height of this dictionaryBST, as the number of nodes 
	 * from root to the deepest leaf DictionaryWord node.
	 * 
	 * @return the height of this Binary Search Tree counting the number of DictionaryWord nodes
	 */
	public int height() {
		return heightHelper(root);
	}
	
	/**
	 * Recursive helper method that computes the height of the subtree rooted at current
	 * 
	 * @param current pointer to the current DictionaryWord within this DictionaryBST
	 * @return height of the subtree rooted at current counting the number of   
	 * DictionaryWord nodes from the current node to the deepest leaf in the subtree
	 * rooted at current
	 */
	private static int heightHelper(DictionaryWord current) {
		//return 0 if null
		if (current == null) {
			return 0;
		}
		//get the current height
		int leftHeight = heightHelper(current.getLeftChild());
		int rightHeight = heightHelper(current.getRightChild());
		//include itself in the height
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		}
		else {
			return rightHeight + 1;
		}
	}
	
	/**
	 * add words to the dictionary
	 * 
	 * @param word String that represents a word
	 * @param meaning String thats the words definition
	 * @return bool of whether or not the add was successful
	 */
	public boolean addWord(String word, String meaning) { 
		boolean next;
		//if empty, redefine the root as the new word
		if (this.isEmpty()) {
			this.root = new DictionaryWord(word, meaning);
			return true;
		}
		//else return the current index and the word and wordhelper will place it
		else {
			next = addWordHelper(new DictionaryWord(word, meaning), this.root);
			return next;
		}
	}

	/**
	 * Recursive helper method to add newWord in the subtree rooted at node
	 * 
	 * @param newWordNode a new DictionaryWord to be added to this dictionaryBST
	 * @param current the current DictionaryWord that is the root of the subtree where 
	 *        newWord will be inserted
	 * @return true if the newWordNode is successfully added to this dictionary, false otherwise
	 */
	private static boolean addWordHelper(DictionaryWord newWordNode, DictionaryWord current) {
		//if the word equals another word, we won't add it twice
		if (current.getWord().equalsIgnoreCase(newWordNode.getWord())) {
			return false;
		}
		//if its lower than the other word, it goes to the left
		else if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) < 0) {
			if (current.getLeftChild() != null) { 
				addWordHelper(newWordNode, current.getLeftChild());
			}
			else {
				current.setLeftChild(newWordNode);
				return true;
			}
		}
		//if its higher than the other word, it goes to the right
		else if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) > 0) {
			if (current.getRightChild() != null) {
				addWordHelper(newWordNode, current.getRightChild());
			}
			else { 
				current.setRightChild(newWordNode);
				return true;
			}
		}
		return true;
	}
	
	/**
	 * Returns all the words within this dictionary sorted from A to Z
	 * 
	 * @return an ArrayList that contains all the words within this dictionary sorted in 
	 *         the ascendant order
	 */
	public ArrayList<String> getAllWords() {
		//checks if its new and if so creates a new array
		if (this.isEmpty()) {
			return new ArrayList<>();
		}
		return getAllWordsHelper(this.root);
	}
	
	/**
	 * Recursive Helper method that returns a list of all the words stored in 
	 * the subtree rooted at current sorted alphabetically from A to Z
	 * 
	 * @param current pointer to the current DictionaryWord within this dictionaryBST
	 * @return an ArrayList of all the words stored in the subtree rooted at current
	 */
	private static ArrayList<String> getAllWordsHelper(DictionaryWord current) {
		ArrayList<String> allWords = new ArrayList<>();
		//add to the left first
		if(current.getLeftChild() != null) {
			allWords.addAll(getAllWordsHelper(current.getLeftChild()));
		}
		allWords.add(current.getWord());
		//then add right
		if(current.getRightChild() != null) {
			allWords.addAll(getAllWordsHelper(current.getRightChild()));
		}
		return allWords;
	}
}
