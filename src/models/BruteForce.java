package models;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteForce implements PasswordGuesser{
	private ArrayList<Integer> charInts = new ArrayList<Integer>(Arrays.asList(17, 19, 20, 21, 22, 24, 25, 26, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 64, 94));
	private char[] charset;
	private int currentLength = 1;
	private int[] currentGuesses = {0};
	private String guess = "";

	public BruteForce(){
		for(int i = 65; i < 91; i++){
			charInts.add(i);
		}
		for(int i = 97; i < 123; i++){
			charInts.add(i);
		}
		charset = new char[charInts.size()];
		for(int i = 0; i < charset.length; i++){
			charset[i] = (char)charInts.get(i).intValue();
		}
	}
	
	public String getNext(){
		guess = "";
		for(Integer i : currentGuesses){
			guess += charset[i];
		}
		if(currentGuesses[currentLength] == charset.length){
			
		}
		else{
			currentGuesses[currentLength]++;
		}
		return guess;
	}
}
