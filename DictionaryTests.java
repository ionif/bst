import java.util.ArrayList;

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

public class DictionaryTests {

	  /**
	   * Tests add method of BST Dictionary
	   * @return true if passes, else false
	   */
	  public static boolean testAddToBST(){
	    boolean tes = true; // test the variable
	    // String result
	    String expectedList = "[3, cow, silly, funny, love, Big, Moose, couch, them]";
	    DictionaryBST testBST = new DictionaryBST(); // initial BST
	    // add words BST
	    testBST.addWord("love", "meaning");
	    testBST.addWord("funny","meaning");
	    testBST.addWord("Big","meaning");
	    testBST.addWord("cow","meaning");
	    testBST.addWord("couch","meaning");
	    testBST.addWord("Moose","meaning");
	    testBST.addWord("silly","meaning");
	    testBST.addWord("them","meaning");
	    testBST.addWord("e","meaning");
	    // test final BST to end string
	    if(!(testBST.getAllWords().toString().equals(expectedList))){
	      tes = false;
	    }
	    return tes;
	  }

	  /**
	   * Test functionality of add method when it's duplicated
	   * @return true if passes, else false
	   */
	  public static boolean testAddDuplicate(){
	    boolean resu = true; // test the variable
	    // String result
	    String expectedList = "[3, cow, silly, funny, love, Big, Moose, couch, them]";
	    DictionaryBST testBST = new DictionaryBST(); // initial BST
	    // add words BST
	    testBST.addWord("love", "meaning");
	    testBST.addWord("funny","meaning");
	    testBST.addWord("Big","meaning");
	    testBST.addWord("cow","meaning");
	    testBST.addWord("couch","meaning");
	    testBST.addWord("Moose","meaning");
	    testBST.addWord("silly","meaning");
	    testBST.addWord("silly","meaning"); // silly added two times
	    testBST.addWord("them","meaning");
	    testBST.addWord("e","meaning");
	    // test final BST to end string
	    if(!(testBST.getAllWords().toString().equals(expectedList))){
	      resu = false;
	    }
	    return resu;
	  }

	  /**
	   * Test size method returns correct count in BST
	   * @return true if passes, else false
	   */
	  public static boolean testSize(){
	    boolean resu = true; // test variable
	    DictionaryBST testBST = new DictionaryBST(); // initial BST
	 // add words BST
	    testBST.addWord("love", "meaning");
	    testBST.addWord("funny","meaning");
	    testBST.addWord("Big","meaning");
	    testBST.addWord("cow","meaning");
	    testBST.addWord("couch","meaning");
	    testBST.addWord("Moose","meaning");
	    testBST.addWord("silly","meaning");
	    testBST.addWord("silly","meaning"); // silly added two times
	    testBST.addWord("them","meaning");
	    testBST.addWord("e","meaning");
	    // tests final BST to size expected
	    if(!(testBST.size() != 10)){
	      resu = false;
	    }
	    return resu;

	  }

	   /**
	   * Tests height method and checks if measures height of tree correctly
	   * @return true if passes, else false
	   */
	  public static boolean testHeight(){
	      boolean resu = true; // tess the variable
	      DictionaryBST testBST = new DictionaryBST(); // initial BST
	      // add words BST
	      testBST.addWord("love", "meaning");
	      testBST.addWord("funny","meaning");
	      testBST.addWord("Big","meaning");
	      testBST.addWord("cow","meaning");
	      testBST.addWord("couch","meaning");
	      testBST.addWord("Moose","meaning");
	      testBST.addWord("silly","meaning");
	      testBST.addWord("silly","meaning"); // silly added two times
	      testBST.addWord("them","meaning");
	      testBST.addWord("e","meaning");
	      // tests final BST to size expected
	      if(!(testBST.height() != 3)){
	        resu = false;
	      }
	      return resu;

	  }

	  /**
	   * Tests that the isEmpty method returns false when not empty
	   * @return true if passes, else false
	   */
	  public static boolean testIsEmpty(){
	    boolean resu = true; // test the variable
	    DictionaryBST testBST = new DictionaryBST(); 
	    if(!testBST.isEmpty()){ // tests that it's empty
	      resu = false;
	    }
	    // add words BST
	    testBST.addWord("couch", "meaning");
	    if(testBST.isEmpty()){ //test that it's not empty
	      resu = false;
	    }
	    return resu;
	  }

	  /**
	   * Performs tests on the dictionary BST
	   */
	  public static void main(String[] args){
	    System.out.println("Test add to BST: " + testAddToBST());
	    System.out.println("Test add duplicate to BST: " + testAddDuplicate());
	    System.out.println("Test size function: "+ testSize());
	    System.out.println("Test height function: " + testHeight());
	    System.out.println("Test isEmpty function: " + testIsEmpty());
	  }
	}
