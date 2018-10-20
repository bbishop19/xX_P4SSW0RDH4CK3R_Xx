package models;

import java.util.Calendar;
import java.util.Scanner;

public class WindwardHacker implements PasswordGuesser{
    private Scanner nounlist;
    private char[] specialCharacters;
    private int index;
    private String currentWord;
    private int yearModifier;

    public WindwardHacker(){
        specialCharacters = new char[]{'!', '@', '#', '$', '%', '^', '&', '*',};
        index = 0;
        yearModifier = 0;

        try{
            nounlist = new Scanner(getClass().getResourceAsStream("nounlist"));
        }catch(Exception e){}

        if(nounlist.hasNext()) {
            currentWord = nounlist.next();
        }
    }

    public String getNext(){
        String password = currentWord + specialCharacters[index];

        //gets year, then adds 1 to it if it is July or later, then adds the current year we are testing
        password += Calendar.getInstance().get(Calendar.YEAR) +  (Calendar.getInstance().get(Calendar.MONTH)+5)/11 + yearModifier;

        if (++yearModifier == 6){
            yearModifier = 0;
            if(++index == specialCharacters.length){
                index = 0;
                if(nounlist.hasNext()){
                    currentWord = nounlist.next();
                }else{
                    return null;
                }
            }
        }
        return password;
    }

    public void closeScanner(){
        nounlist.close();
    }
}
