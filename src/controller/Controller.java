package controller;

import javafx.scene.text.Text;
import models.*;

public abstract class Controller {	
	//crack a password and return an object containing whether it was successful and the time and attempts taken
	public static CrackInfo crack(String password, PasswordGuesser guesser){
		String guess;
		boolean cracked = true;
		int attempts = 0;
		long time = System.currentTimeMillis();
		do {
			guess = guesser.getNext();
			if(System.currentTimeMillis() - time > 30000){
				guess = null;
			}
			attempts++;
		}while (guess != null && !guess.equals(password));

		if (guess == null){
			attempts--;
			cracked = false;
		}

		time = System.currentTimeMillis() - time;
		return new CrackInfo(cracked, time, attempts);
	}

	//crack a password and display the results
	public static void crackAndDisplay(String password, PasswordGuesser pg, Text a, Text b, Text c){
		if(password.isEmpty()){
			a.setText("");
			b.setText("Please enter a password and try again");
			c.setText("");
		}else {
			CrackInfo info = crack(password, pg);
			if (info.getCracked()) {
				a.setText("Your password was cracked in");
			} else {
				a.setText("Your password was NOT cracked in");
			}

			b.setText(info.getTime() + " ms and");
			c.setText(info.getAttempts() + " attempts");
		}
	}

	
	//individual crack/display functions
	public static void windwardCrackAndDisplay(String password, Text a, Text b, Text c){
		crackAndDisplay(password, new WindwardHacker(), a, b, c);
		if(!a.getText().contains("NOT") && !a.getText().isEmpty()){
			c.setText(c.getText() + ". Not much you can do about this one.");
		}
	}

	public static void commonCrackAndDisplay(String password, Text a, Text b, Text c){
		crackAndDisplay(password, new CommonHacker(), a, b, c);
		if(!a.getText().contains("NOT")  && !a.getText().isEmpty()){
			c.setText(c.getText() + ". Try using a password most people wouldn't choose.");
		}
	}

	public static void bruteForceCrackAndDisplay(String password, Text a, Text b, Text c){
		crackAndDisplay(password, new BruteForcer(), a, b, c);
		if(!a.getText().contains("NOT")  && !a.getText().isEmpty()){
			c.setText(c.getText() + ". Try using a longer password.");
		}
	}
}
