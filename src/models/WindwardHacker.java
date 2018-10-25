package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Scanner;

public class WindwardHacker implements PasswordGuesser{
    private BufferedReader nounlist;
    private char[] specialCharacters;
    private int index;
    private String currentWord;
    private int yearModifier;
    boolean returningNull;

    public WindwardHacker(){
        specialCharacters = new char[]{'!', '@', '#', '$', '%', '^', '&', '*'};
        index = 0;
        yearModifier = 0;
        returningNull = false;

        try{
            nounlist = new BufferedReader(new FileReader(getClass().getClassLoader().getResource("words").getFile()));
        }catch(Exception e){
            returningNull = true;
        }
    }

    public String getNext(){
        if(returningNull){
            return null;
        }

        String password = currentWord + specialCharacters[index];

        //gets year, then adds 1 to it if it is July or later, then adds the current year we are testing
        password += Calendar.getInstance().get(Calendar.YEAR) +  (Calendar.getInstance().get(Calendar.MONTH)+5)/11 + yearModifier;

        if (++yearModifier == 6){
            yearModifier = 0;
            if(++index == specialCharacters.length){
                index = 0;
                try{
                    currentWord = nounlist.readLine();
                }catch (Exception e){
                    returningNull = true;
                }
            }
        }
        return password;
    }
}
